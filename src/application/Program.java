package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("Teste1");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("Teste2");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("Teste3");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);

		}
		System.out.println("Teste4");
		Seller newSeller = new Seller(null, "Kayo", "Kayo@gmail.com", new Date(), 3500.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted new id: " + newSeller.getId());
	}

}
