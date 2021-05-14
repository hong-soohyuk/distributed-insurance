package Main;

import java.util.Scanner;

import commonValue.enums.job;
import customer.Customer;
import customer.CustomerList;
import customer.CustomerListImple;
import customer.Property;
import insurance.CarInsurance;
import insurance.Insurance;
import insurance.InsuranceList;
import insurance.InsuranceListImpl;
import insurance.LifeInsurance;
import registration.Registration;
import registration.RegistrationList;
import registration.RegistrationListImpl;
import registration.Registrator;

public class Main {
	
	private static Scanner scanner  = new Scanner(System.in);
	
	public static void main(String[] args) {

		CustomerList customerList = new CustomerListImple();
		InsuranceList insuranceList = new InsuranceListImpl();
		RegistrationList registrationList = new RegistrationListImpl();
		Registrator registrator = new Registrator(registrationList);
		
		boolean doLoop = true;
		while(doLoop){
			System.out.println("~~~~~보험사 메뉴~~~~~");
			System.out.print("1. 고객 가입하기 "+"2. 보험 상품 개발하기 "+"3. 보험 상품 신청하기 "+"4. 가입 심사하기 "+"5. 시스템 나가기\n");
			
			switch (scanner.nextInt()) {
			case 1: registCustomer(customerList); break;
			case 2 : createInsurance(insuranceList); break;
			case 3 : registInsurance(customerList, insuranceList, registrator); break;
			case 4 : gradeRegistration(registrator, registrationList); break;
			case 5 : doLoop = false; break;
			default : break;
			}
		}
	}
	private static void registCustomer(CustomerList customerList) {
		Customer customer = new Customer();
		System.out.println("고객의 아이디를 입력해주세요 : "); customer.setCustomerID(scanner.next());
		
		System.out.println("고객의 성명을 입력해주세요 : "); customer.setName(scanner.next());
		
		System.out.println("고객의 나이를 입력해주세요 : "); customer.setAge(scanner.nextInt());
		
		System.out.println("고객의 직업을 입력해주세요 : " + "1. 운전 기사 "+" 2. 군인 "+ "3. 사무직 "+ "4. 무직");
		switch(scanner.nextInt()) {
			case 1 : customer.setJob(job.DRIVER); break;
			case 2 : customer.setJob(job.MILITARYSERVICE); break;
			case 3 : customer.setJob(job.OFFICEWORKER); break;
			case 4 : customer.setJob(job.UNEMPLOYED); break;
			default : break;
		}
		
		Property property = customer.getProperty();
		System.out.println("고객의 자동차의 가격를 입력해주세요 : ");	property.setCar(scanner.nextLong());
		System.out.println("고객의 집 가격을 입력해주세요 : "); property.setHouse(scanner.nextLong());
		
		customer.setProperty(property);
		customerList.add(customer);
		
		System.out.println("고객 등록을 마쳤습니다.");
	}
	private static void createInsurance(InsuranceList insuranceList) {
			System.out.println("설계하고자 하는 보험의 종류를 선택해 주세요.\n" + "1. 생명보험 " + "2. 자동차 보험 " + "3. 보험 설계 나가기.");
			Insurance insurance = null;
			switch(scanner.nextInt()) {
				case 1 : insurance = new LifeInsurance(); break;
				case 2 : insurance = new CarInsurance(); break;
				case 3 : insurance = null; break;
				default : break;
			}
			if(insurance != null) {
				System.out.println("보험의 ID를 설정해주세요."); insurance.setInsuranceID(scanner.next());
				System.out.println("생명보험의 이름을 설정해주세요."); insurance.setName(scanner.next());
				insuranceList.add(insurance);
				System.out.println("보험 등록이 완료되었습니다.");
			}
	}
	
	private static void registInsurance(CustomerList customerList, InsuranceList insuranceList, Registrator registrator) {
		System.out.println("보험에 등록하고자 하는 고객의 ID를 입력해주세요.");
		for(Customer cust : customerList.getCustomers())  {System.out.print(cust.getCustomerID() +" : "+ cust.getName()+", ");}
		Customer registeredCustomer = customerList.search(scanner.next());
		if(registeredCustomer == null) {System.out.println("아이디를 잘못 입력하셨습니다.");}
		else {
			System.out.println("등록하고자 하는 보험의 ID를 입력해주세요.");
			for(Insurance insu : insuranceList.getInsuranceList()) {System.out.println(insu.getInsuranceID());}
			Insurance registeredInsurance = insuranceList.search(scanner.next());
			if(registeredInsurance == null) {System.out.println("아이디를 잘못 입력하셨습니다.");}
			else {
				Registration registration = new Registration();
				registration.register(registeredCustomer, registeredInsurance);
				if(registrator.registrate(registration))
				{System.out.println("신청 완료했습니다.");}
				else {System.out.println("다시 시도해주세요.");}
			}
		}
	}
	private static void gradeRegistration(Registrator registrator, RegistrationList registrationList) {
		System.out.println("심사를 원하는 가입 신청 ID를 입력해주세요.");
		for(Registration regist : registrationList.getRegistrationList())  {System.out.print(regist.getRegistrationID() + ", ");}
		Registration registration = registrationList.search(scanner.next());
		if(registration == null) { {System.out.println("신청 아이디를 잘못 입력하셨습니다.");}}
		else {
			Insurance registeredInsurance = registration.getInsurance();
			Customer registeredCustomer = registration.getCustomer();
			registeredInsurance.calculateRate(registeredCustomer);
			System.out.println(
					"고객 번호 : "+ registeredCustomer.getCustomerID() +
					", 고객 성명 : " + registeredCustomer.getName()+
					". 위 고객의 " + registeredInsurance.getName()+" 보험 요율은"+ registeredInsurance.getRatio()+" 입니다.");
			System.out.println();
			System.out.println("보험요율 심사 결과: "+ registration.getApproval());
		}
	}
	
	
}