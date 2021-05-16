package Main;

import java.util.Scanner;

import client.Client;
import client.ClientList;
import client.ClientListImple;
import client.Property;

import commonValue.enums.job;
import commonValue.enums.travelAreaGrade;
import insurance.CarInsurance;
import insurance.DriverInsurance;
import insurance.FireInsurance;
import insurance.Insurance;
import insurance.InsuranceList;
import insurance.InsuranceListImpl;
import insurance.TravellerInsurance;
import registration.Contract;
import registration.ContractList;
import registration.ContractListImpl;
import registration.Registrator;

public class Main {
	
	private static Scanner scanner  = new Scanner(System.in);
	
	public static void main(String[] args) {
		ClientList customerList = new ClientListImple();
		InsuranceList insuranceList = new InsuranceListImpl();
		ContractList contractList = new ContractListImpl();
		Registrator registrator = new Registrator(contractList);
		
		boolean doLoop = true;
		while(doLoop){
			System.out.println("~~~~~보험사 메뉴~~~~~");
			System.out.print("1. 고객 가입하기 "+"2. 보험 상품 개발하기 "+"3. 보험 상품 신청하기 "+"4. 가입 심사하기 "+"5. 시스템 나가기\n");
			
			switch (scanner.nextInt()) {
			case 1 : registCustomer(customerList); break;
			case 2 : createInsurance(insuranceList); break;
			case 3 : registInsurance(customerList, insuranceList, registrator); break;
			case 4 : gradeRegistration(registrator, contractList); break;
			case 5 : doLoop = false; break;
			default : break;
			}
		}
	}
	private static void registCustomer(ClientList customerList) {
		Client client = new Client();
		System.out.println("고객의 아이디를 입력해주세요 : "); client.setCustomerID(scanner.next());
		
		System.out.println("고객의 성명을 입력해주세요 : "); client.setName(scanner.next());
		
		System.out.println("고객의 나이를 입력해주세요 : "); client.setAge(scanner.nextInt());
		
		System.out.println("고객의 직업을 입력해주세요 : " + "1. 운송업 기사 "+" 2. 서비스직(운전) "+
		"3. 서비스직(여행) "+ "4. 주부 및 기타 비경제활동 " + "5. 기타 사무직 "+"6. 기타 생산직 ");
		
		switch(scanner.nextInt()) {		
			case 1 : client.setJob(job.DRIVER); break;
			case 2 : client.setJob(job.SERVICE_DRIVER); break;
			case 3 : client.setJob(job.SERVICE_TRAVEL); break;
			case 4 : client.setJob(job.UNEMPLOYED); break;
			case 5 : client.setJob(job.ETC_OFFICEWORKER); break;
			case 6 : client.setJob(job.ETC_BLUECOLLAR); break;
			default : break;
		}
		
		Property property = client.getProperty();
		System.out.println("고객의 자동차의 가격를 입력해주세요 : "); property.setCar(scanner.nextLong());
		System.out.println("고객의 집 가격을 입력해주세요 : "); property.setHouse(scanner.nextLong());
		
		client.setProperty(property);
		customerList.add(client);
		
		System.out.println("고객 등록을 마쳤습니다.");
	}
	private static void createInsurance(InsuranceList insuranceList) {
			System.out.println("설계하고자 하는 보험의 종류를 선택해 주세요.\n" +
	"1. 운전자 보험 " + "2. 자동차 보험 " +"3. 화재 보험 "+"4. 여행자 보험 "+ "5. 보험 설계 나가기 ");
			Insurance insurance = null;
			switch(scanner.nextInt()) {
				case 1 : insurance = new DriverInsurance(); break;
				case 2 : insurance = new CarInsurance(); break;
				case 3 : insurance = new FireInsurance(); break;
				case 4 : insurance = new TravellerInsurance(); break;
				case 5 : insurance = null; break;
				default : break;
			}
			if(insurance != null) {
				System.out.println("보험의 ID를 설정해주세요."); insurance.setInsuranceID(scanner.next());
				System.out.println("보험의 이름을 설정해주세요."); insurance.setName(scanner.next());
				insuranceList.add(insurance);
				System.out.println("보험 등록이 완료되었습니다.");
			}
	}
	
	private static void registInsurance(ClientList customerList, InsuranceList insuranceList, Registrator registrator) {
		System.out.println("보험에 등록하고자 하는 고객의 ID를 입력해주세요.");
		for(Client client : customerList.getCustomers())  {System.out.print(client.getCustomerID() +" : "+ client.getName()+" ");}
		Client registeredClient = customerList.search(scanner.next());
		if(registeredClient == null) {System.out.println("아이디를 잘못 입력하셨습니다.");}
		else {
			System.out.println("등록하고자 하는 보험의 ID를 입력해주세요.");
			for(Insurance insurance : insuranceList.getInsuranceList()) {System.out.println(insurance.getInsuranceID() +" : "+insurance.getName()+" ");}
			Insurance registeredInsurance = insuranceList.search(scanner.next());
			if(registeredInsurance == null) {System.out.println("아이디를 잘못 입력하셨습니다.");}
			else {
				Contract contract = new Contract();
				insuranceDetails(registeredClient, registeredInsurance, contract);
				
				contract.register(registeredClient, registeredInsurance);
				if(registrator.register(contract))
				{System.out.println("신청 완료했습니다.");}
				else {System.out.println("다시 시도해주세요.");}
			}
		}
	}
	
	private static void insuranceDetails(Client registeredClient, Insurance registeredInsurance, Contract contract) {
		switch(registeredInsurance.getType()) {
		case CAR : System.out.println("고객의 사고횟수를 설정해주세요."); registeredClient.setAddidentHistory(scanner.nextInt()); 
			break;
		
		case DRIVER : System.out.println("고객의 운전경력 설정해주세요."); registeredClient.setDrivingExperience(scanner.nextInt()); 
			break;
		
		case FIRE : break;
		
		case TRAVELLER : System.out.println("고객의 여행지역 위험도를 설정해주세요.\n"+
		"1. 1단계 여행유의 "+"2. 2단계 여행자제 "+"3. 3단계 철수권고 "+"4. 4단계 여행금지 "+"5. 특별 경보");
			int area = scanner.nextInt();
			if(area == 1) {registeredClient.setAreaGrade(travelAreaGrade.FIRST);}
			else if(area == 2) {registeredClient.setAreaGrade(travelAreaGrade.SECOND);}
			else if(area == 3) {registeredClient.setAreaGrade(travelAreaGrade.THIRD);}
			else if(area == 4) {registeredClient.setAreaGrade(travelAreaGrade.FOURTH);}
			else if(area == 5) {registeredClient.setAreaGrade(travelAreaGrade.SPECIAL);}
			break;
		
		default : break;
		}		
	}
	
	private static void gradeRegistration(Registrator registrator, ContractList registrationList) {
		System.out.println("심사를 원하는 가입 신청 ID를 입력해주세요.");
		for(Contract regist : registrationList.getRegistrationList())  {System.out.print(regist.getRegistrationID() + ", ");}
		Contract contract = registrationList.search(scanner.next());
		if(contract == null) { {System.out.println("신청 아이디를 잘못 입력하셨습니다.");}}
		else {
			Insurance registeredInsurance = contract.getInsurance();
			Client registeredClient = contract.getClient();
			
			contract.calculateRate();

			System.out.println(
					"고객 번호 : "+ registeredClient.getCustomerID() +
					", 고객 성명 : " + registeredClient.getName()+
					". 위 고객의 " + registeredInsurance.getName()+" 보험 요율은 "+ contract.getInsuranceRatio()+" 입니다.");
			System.out.println();
			
			contract.calculateGrade();
			System.out.println("보험 계약 심사 결과, 점수는 "+ contract.getContractGrade()+" 으로, " +contract.getApproval()+" 입니다.");
		}
	}
}