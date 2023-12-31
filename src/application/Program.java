package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);	
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("Teste1: seller findById");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("Teste2: seller findByDepartment");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("Teste3: seller findAll ");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);

		}
		System.out.println("Teste4: seller insert");
		Seller newSeller = new Seller(null, "Kayo", "Kayo@gmail.com", new Date(), 3500.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted new id: " + newSeller.getId());
		
		System.out.println("Teste5: seller update");
		seller = sellerDao.findById(1);
		seller.setName("Marquinho");
		sellerDao.update(seller);
		System.out.println("Updated!");
		
		System.out.println("Teste6: seller delete");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");

	}

}
