package pl.pawel.library.service;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pl.pawel.library.entity.Book;
import pl.pawel.library.entity.Type;
import pl.pawel.library.repository.BookRepository;
import pl.pawel.library.repository.TypeRepository;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

@Service
public class StorageServiceImpl implements StorageService{
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private TypeRepository typeRepository;
	
	private FileInputStream inputStream;
	private Workbook workbook;
	private Sheet sheet;
	private Iterator<Row> iterator;
	private List<Book> books;
	private List<Type> types;
	
	public void saveDataFile(MultipartFile filename) {
		readFile(filename);
		saveBookTypeToDB();
		saveBooksToDB();
		
		System.out.println("koniec ładowania pliku");
	}
	
	private void saveBooksToDB() {
		getSheet(1);
		getRowFromFile();
		getBookFromFile();
		bookRepository.saveAll(books);
	}
	
	private void saveBookTypeToDB() {
		getSheet(0);
		getRowFromFile();
		getBookTypeFromFile();
		typeRepository.saveAll(types);
	}

	private void readFile(MultipartFile multipartFile) {
		try {
			inputStream = (FileInputStream) multipartFile.getInputStream();
			workbook = new HSSFWorkbook(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void getSheet(int sheetNumber) {
		sheet = workbook.getSheetAt(sheetNumber);
	}
	
	private void getRowFromFile() {
		 iterator = sheet.iterator();
	}
	
	private void getBookFromFile() {
		books = new ArrayList<>();
		String title = "";
		String author= "";
		String description= "";
		Book book= null;
		while(iterator.hasNext()) { 
			Row currentRow = iterator.next();
			Iterator<Cell> cellIterator = currentRow.iterator();
			book= new Book();
			while(cellIterator.hasNext()) {
				
				Cell currentCell= cellIterator.next();
				if(currentCell.getAddress().getColumn()==0) {
					title = currentCell.getStringCellValue();
				}
				if(currentCell.getAddress().getColumn()==1) {
					author = currentCell.getStringCellValue();
				}
				if(currentCell.getAddress().getColumn()==3) {
					description = currentCell.getStringCellValue();
				}
				if(currentCell.getAddress().getColumn()==2) {
					String cell = currentCell.getStringCellValue();
					cell = cell.replaceAll("\\s+", "");
					cell = cell.replaceAll("\\(", "");
					cell = cell.replaceAll("\\)", "");
					String parts[] = cell.split(";");
					
					for (String part : parts) {
						for (Type type : types) {
							if(type.getShortcut().equals(part)) {
								type.addBook(book);
							}
						}
					}
				}
			}
			book.setTitle(title);
			book.setAuthor(author);
			book.setDescription(description);
			book.setAvailableNumber(1);
			books.add(book);
		}
	}
	private void getBookTypeFromFile() {
		types = new ArrayList<>();
		String cell = "";
		String type = "";
		String shortcut = "";
	
		while(iterator.hasNext()) {
			Row currentRow = iterator.next();
			Iterator<Cell> cellIterator = currentRow.iterator();
			
			while(cellIterator.hasNext()) {
				Cell currentCell = cellIterator.next();
				cell = currentCell.getStringCellValue();
		
				String parts [] =cell.replaceAll("\\s+","").split("-");
				
				type = parts[1];
				shortcut = parts[0];
			}
			types.add(new Type(type, shortcut));
		}
	}

	@Override
	public List<Book> getBooks() {
		
		return bookRepository.findAll();
	}
	
}
