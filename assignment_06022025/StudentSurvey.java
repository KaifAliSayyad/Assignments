import java.util.*;
import java.util.stream.*;

public class StudentSurvey{
	public static void main(String[] args){
		List<Student> students = new ArrayList<>();
		students.add(new Student(101, "Saif", 12, 6, "GSA", "MALE", 92.16, new Fees(100000, 75000)));
		students.add(new Student(1, "Kaif", 12, 6, "GSA", "MALE", 95.16, new Fees(100000, 75000)));
students.add(new Student(2, "Aisha", 14, 7, "DPS", "FEMALE", 88.45, new Fees(120000, 80000)));
students.add(new Student(3, "Ravi", 15, 8, "KVM", "MALE", 92.30, new Fees(110000, 90000)));
students.add(new Student(4, "Maya", 13, 6, "SCH", "FEMALE", 80.50, new Fees(95000, 70000)));
students.add(new Student(5, "Aryan", 16, 9, "ABC", "MALE", 85.60, new Fees(115000, 85000)));
students.add(new Student(6, "Rina", 14, 7, "DPS", "FEMALE", 90.75, new Fees(130000, 105000)));
students.add(new Student(7, "Sahil", 12, 6, "GSA", "MALE", 89.20, new Fees(100000, 80000)));
students.add(new Student(8, "Neha", 15, 8, "KVM", "FEMALE", 78.35, new Fees(105000, 65000)));
students.add(new Student(9, "Vikas", 13, 7, "SCH", "MALE", 91.00, new Fees(95000, 75000)));
students.add(new Student(10, "Zara", 16, 9, "ABC", "FEMALE", 86.80, new Fees(120000, 95000)));
students.add(new Student(11, "Ishaan", 14, 6, "DPS", "MALE", 93.40, new Fees(110000, 80000)));
students.add(new Student(12, "Tanya", 15, 7, "KVM", "FEMALE", 82.50, new Fees(120000, 70000)));
students.add(new Student(13, "Ali", 13, 6, "GSA", "MALE", 77.60, new Fees(100000, 60000)));
students.add(new Student(14, "Sana", 14, 7, "SCH", "FEMALE", 88.90, new Fees(95000, 78000)));
students.add(new Student(15, "Aditya", 16, 9, "ABC", "MALE", 91.15, new Fees(115000, 93000)));
students.add(new Student(16, "Khushboo", 15, 8, "DPS", "FEMALE", 84.80, new Fees(130000, 90000)));
students.add(new Student(17, "Vishal", 12, 6, "KVM", "MALE", 79.40, new Fees(100000, 72000)));
students.add(new Student(18, "Pooja", 14, 7, "SCH", "FEMALE", 95.50, new Fees(110000, 86000)));
students.add(new Student(19, "Manav", 15, 8, "GSA", "MALE", 87.65, new Fees(105000, 76000)));
students.add(new Student(20, "Simran", 13, 6, "ABC", "FEMALE", 90.00, new Fees(120000, 80000)));
students.add(new Student(21, "Vikram", 14, 7, "DPS", "MALE", 92.00, new Fees(125000, 92000)));
students.add(new Student(22, "Ritika", 16, 9, "KVM", "FEMALE", 80.25, new Fees(110000, 70000)));
students.add(new Student(23, "Ankit", 13, 6, "SCH", "MALE", 85.80, new Fees(100000, 78000)));
students.add(new Student(24, "Tara", 15, 8, "GSA", "FEMALE", 87.10, new Fees(115000, 88000)));
students.add(new Student(25, "Siddharth", 12, 6, "ABC", "MALE", 83.50, new Fees(120000, 85000)));
students.add(new Student(26, "Aarav", 14, 7, "DPS", "MALE", 91.60, new Fees(130000, 94000)));
students.add(new Student(27, "Nina", 13, 6, "KVM", "FEMALE", 94.75, new Fees(110000, 98000)));
students.add(new Student(28, "Sahil", 16, 9, "SCH", "MALE", 79.30, new Fees(125000, 80000)));
students.add(new Student(29, "Ravina", 12, 6, "GSA", "FEMALE", 82.70, new Fees(100000, 75000)));
students.add(new Student(30, "Harsh", 14, 7, "ABC", "MALE", 90.40, new Fees(115000, 90000)));
students.add(new Student(31, "Meera", 13, 6, "DPS", "FEMALE", 95.90, new Fees(105000, 80000)));
students.add(new Student(32, "Mohan", 15, 8, "KVM", "MALE", 91.90, new Fees(120000, 93000)));
students.add(new Student(33, "Kavya", 16, 9, "SCH", "FEMALE", 88.10, new Fees(125000, 85000)));
students.add(new Student(34, "Raghav", 12, 6, "GSA", "MALE", 84.55, new Fees(100000, 77000)));
students.add(new Student(35, "Arpita", 14, 7, "ABC", "FEMALE", 90.95, new Fees(110000, 87000)));
students.add(new Student(36, "Nikhil", 15, 8, "DPS", "MALE", 81.30, new Fees(130000, 76000)));
students.add(new Student(37, "Simran", 13, 6, "KVM", "FEMALE", 91.80, new Fees(120000, 89000)));
students.add(new Student(38, "Aarav", 16, 9, "SCH", "MALE", 87.55, new Fees(115000, 83000)));
students.add(new Student(39, "Diya", 12, 6, "GSA", "FEMALE", 94.25, new Fees(100000, 90000)));
students.add(new Student(40, "Tanmay", 14, 7, "ABC", "MALE", 78.60, new Fees(110000, 70000)));
students.add(new Student(41, "Priti", 15, 8, "DPS", "FEMALE", 92.50, new Fees(125000, 95000)));
students.add(new Student(42, "Rishabh", 13, 6, "KVM", "MALE", 85.40, new Fees(105000, 75000)));
students.add(new Student(43, "Aaradhya", 14, 7, "SCH", "FEMALE", 96.60, new Fees(115000, 88000)));
students.add(new Student(44, "Dev", 16, 9, "GSA", "MALE", 79.10, new Fees(120000, 65000)));
students.add(new Student(45, "Aditi", 12, 6, "ABC", "FEMALE", 83.20, new Fees(100000, 70000)));
students.add(new Student(46, "Akhil", 14, 7, "DPS", "MALE", 94.50, new Fees(110000, 92000)));
students.add(new Student(47, "Ananya", 13, 6, "KVM", "FEMALE", 87.80, new Fees(105000, 78000)));
students.add(new Student(48, "Arvind", 15, 8, "SCH", "MALE", 80.00, new Fees(115000, 85000)));
students.add(new Student(49, "Ishita", 16, 9, "GSA", "FEMALE", 92.30, new Fees(120000, 93000)));
students.add(new Student(50, "Suresh", 12, 6, "ABC", "MALE", 81.70, new Fees(100000, 72000)));
students.add(new Student(51, "Abhinav", 14, 7, "DPS", "MALE", 33.20, new Fees(120000, 45000))); // Fail
students.add(new Student(52, "Rita", 15, 8, "KVM", "FEMALE", 29.80, new Fees(110000, 30000))); // Fail
students.add(new Student(53, "Jatin", 16, 9, "SCH", "MALE", 38.10, new Fees(120000, 47000))); // Fail
students.add(new Student(54, "Nupur", 14, 7, "ABC", "FEMALE", 36.50, new Fees(115000, 60000))); // Fail
students.add(new Student(55, "Kunal", 13, 6, "DPS", "MALE", 42.00, new Fees(105000, 72000))); // Fail
students.add(new Student(56, "Manya", 15, 8, "KVM", "FEMALE", 89.50, new Fees(130000, 80000)));
students.add(new Student(57, "Hitesh", 14, 7, "SCH", "MALE", 63.30, new Fees(110000, 55000)));
students.add(new Student(58, "Niharika", 13, 6, "GSA", "FEMALE", 90.20, new Fees(100000, 87000)));
students.add(new Student(59, "Aman", 16, 9, "ABC", "MALE", 78.40, new Fees(115000, 65000)));
students.add(new Student(60, "Sanya", 14, 7, "DPS", "FEMALE", 92.80, new Fees(120000, 91000)));
students.add(new Student(61, "Gaurav", 12, 6, "KVM", "MALE", 86.50, new Fees(105000, 80000)));
students.add(new Student(62, "Sheetal", 13, 6, "SCH", "FEMALE", 90.75, new Fees(100000, 85000)));
students.add(new Student(63, "Aniket", 15, 8, "ABC", "MALE", 71.30, new Fees(110000, 77000)));
students.add(new Student(64, "Meenal", 14, 7, "DPS", "FEMALE", 87.90, new Fees(120000, 82000)));
students.add(new Student(65, "Samir", 12, 6, "KVM", "MALE", 81.50, new Fees(100000, 76000)));
students.add(new Student(66, "Simran", 13, 6, "SCH", "FEMALE", 66.00, new Fees(105000, 67000)));
students.add(new Student(67, "Pratik", 16, 9, "GSA", "MALE", 74.50, new Fees(120000, 68000)));
students.add(new Student(68, "Suman", 15, 8, "ABC", "FEMALE", 83.20, new Fees(115000, 80000)));
students.add(new Student(69, "Siddhi", 14, 7, "DPS", "FEMALE", 72.90, new Fees(120000, 76000)));
students.add(new Student(70, "Rajeev", 13, 6, "KVM", "MALE", 93.60, new Fees(105000, 88000)));
students.add(new Student(71, "Vani", 12, 6, "SCH", "FEMALE", 78.90, new Fees(100000, 72000)));
students.add(new Student(72, "Deepak", 15, 8, "GSA", "MALE", 88.10, new Fees(115000, 79000)));
students.add(new Student(73, "Tanya", 16, 9, "ABC", "FEMALE", 91.40, new Fees(120000, 92000)));
students.add(new Student(74, "Prashant", 14, 7, "DPS", "MALE", 77.70, new Fees(110000, 75000)));
students.add(new Student(75, "Snehal", 13, 6, "KVM", "FEMALE", 82.30, new Fees(100000, 76000)));
students.add(new Student(76, "Ritesh", 12, 6, "SCH", "MALE", 60.00, new Fees(95000, 55000)));
students.add(new Student(77, "Rupali", 16, 9, "GSA", "FEMALE", 92.70, new Fees(120000, 89000)));
students.add(new Student(78, "Nashit", 15, 8, "ABC", "MALE", 94.20, new Fees(115000, 93000)));
students.add(new Student(79, "Rupesh", 14, 7, "DPS", "MALE", 89.00, new Fees(120000, 82000)));
students.add(new Student(80, "Shruti", 13, 6, "KVM", "FEMALE", 73.80, new Fees(100000, 69000)));
students.add(new Student(81, "Bhuvan", 12, 6, "SCH", "MALE", 68.60, new Fees(95000, 62000)));
students.add(new Student(82, "Sanjana", 16, 9, "GSA", "FEMALE", 90.80, new Fees(120000, 88000)));
students.add(new Student(83, "Reyansh", 14, 7, "ABC", "MALE", 61.40, new Fees(110000, 63000)));
students.add(new Student(84, "Tushar", 13, 6, "DPS", "MALE", 85.30, new Fees(100000, 75000)));
students.add(new Student(85, "Simran", 12, 6, "KVM", "FEMALE", 80.40, new Fees(95000, 70000)));
students.add(new Student(86, "Ananya", 15, 8, "SCH", "FEMALE", 93.90, new Fees(115000, 92000)));
students.add(new Student(87, "Sushant", 16, 9, "GSA", "MALE", 88.60, new Fees(120000, 80000)));
students.add(new Student(88, "Nidhi", 14, 7, "ABC", "FEMALE", 74.00, new Fees(110000, 74000)));
students.add(new Student(89, "Divya", 13, 6, "DPS", "FEMALE", 66.70, new Fees(100000, 69000)));
students.add(new Student(90, "Karthik", 12, 6, "KVM", "MALE", 56.90, new Fees(95000, 65000)));
students.add(new Student(91, "Ravi", 15, 8, "SCH", "MALE", 81.30, new Fees(115000, 78000)));
students.add(new Student(92, "Ramesh", 13, 6, "GSA", "MALE", 79.10, new Fees(100000, 74000)));
students.add(new Student(93, "Vidya", 14, 7, "ABC", "FEMALE", 89.70, new Fees(110000, 79000)));
students.add(new Student(94, "Prakash", 12, 6, "DPS", "MALE", 84.50, new Fees(95000, 72000)));
students.add(new Student(95, "Akriti", 15, 8, "KVM", "FEMALE", 82.60, new Fees(115000, 75000)));
students.add(new Student(96, "Bharat", 16, 9, "SCH", "MALE", 94.90, new Fees(120000, 95000)));
students.add(new Student(97, "Alok", 14, 7, "GSA", "MALE", 68.50, new Fees(110000, 60000)));
students.add(new Student(98, "Prashanthi", 13, 6, "ABC", "FEMALE", 77.30, new Fees(100000, 67000)));
students.add(new Student(99, "Kunal", 15, 8, "DPS", "MALE", 89.90, new Fees(115000, 81000)));
students.add(new Student(100, "Manisha", 12, 6, "KVM", "FEMALE", 91.60, new Fees(95000, 73000)));


		System.out.println("Printing all the students..");
		//System.out.println(students);

		System.out.println("\n1. Counting students in each standard");
		Map<Integer, Long> studentsInEachStandard = students.stream().collect(Collectors.groupingBy(e -> e.getStandard(), Collectors.counting()));
		studentsInEachStandard.forEach((key, value) -> System.out.println("-> "+value+" students in "+key+" Standard"));
		
		System.out.println("\n2. Counting students gender wise");
		Map<String, Long> studentsInEachGender = students.stream().collect(Collectors.groupingBy(e -> e.getGender(), Collectors.counting()));
		studentsInEachGender.forEach((key, value) -> System.out.println("-> "+value+" students are "+key));

		System.out.println("\n3. Student failed/ passed (University wise) ");
		Map<Boolean, Long> studentsFailedOrPassed1 = students.stream().collect(Collectors.partitioningBy(e -> e.getPercentage() >= 40, Collectors.counting()));
		System.out.println("-> Total students passed are "+studentsFailedOrPassed1.get(true));
		System.out.println("-> Total students failed are "+studentsFailedOrPassed1.get(false));

		System.out.println("\n3. Student failed/ passed (School wise) ");
		Map<String, Map<Boolean, Long>> studentsFailedOrPassed2 = students.stream().collect(Collectors.groupingBy(s -> s.getSchool() ,Collectors.partitioningBy(e -> e.getPercentage() >= 40, Collectors.counting())));
		
		studentsFailedOrPassed2.forEach((key, value) -> {
			System.out.println("\n-> Students passed in school "+key+" = "+value.get(true));
			System.out.println("-> Students failed in school "+key+" = "+value.get(false));
		});

		System.out.println("\n4. Top 3 students in University ");
		List<String> top3Students1 = students.stream().sorted(new StudentPercentageComparator()).limit(3).collect(Collectors.toList()).stream().collect(Collectors.mapping(s -> s.getName(), Collectors.toList()));
		System.out.println("->"+top3Students1);


		System.out.println("\n5. Top 3 students in School ");
		Map<String, List<Student>> top3Students2 = students.stream().collect(Collectors.groupingBy(s -> s.getSchool()));
		top3Students2.forEach((key, value)->{
			System.out.println("\nTop 3 Students in "+key+", are -> "+value.stream().sorted(new StudentPercentageComparator()).limit(3).collect(Collectors.mapping(s -> s.getName(), Collectors.toList())));
		});

		System.out.println("\n6. Top Scorer School wise");
		Map<String, List<Student>> topScorerSchool = students.stream().collect(Collectors.groupingBy(s -> s.getSchool()));
		topScorerSchool.forEach((key, value)->{
			System.out.println("Top Scorer in "+key+" is "+value.stream().sorted(new StudentPercentageComparator()).limit(1).collect(Collectors.mapping(s -> s.getName(), Collectors.toList())).get(0));

		});

		System.out.println("\n7. Average age of Male/ Female Students ");
		Map<String, Double> averageAgeofStudentsParitionedByGender = students.stream().collect(Collectors.groupingBy(Student::getGender,Collectors.averagingInt(s -> s.getAge())));

		averageAgeofStudentsParitionedByGender.forEach((key, value)->{
			System.out.println("\n -> Average age of "+key+" Students is "+String.format("%2f",value));			
		});

		System.out.println("\n8. Total Fees pending School wise ");
		Map<String, List<Long>> feesPendingSchoolWise = students.stream().collect(Collectors.groupingBy(Student::getSchool, Collectors.mapping(s -> s.getFees().getFeesPending(), Collectors.toList())));
		feesPendingSchoolWise.forEach((key, value)->{
			System.out.println("Fees Pending for "+key+" = "+value.stream().reduce((a, b)->a+b).get());
		});
		
		System.out.println("\n9. Total number of Students in a University \n-> "+students.size());
		
	}
}

public class StudentPercentageComparator implements Comparator<Student>{
	public int compare(Student e1, Student e2){
		return Double.compare(e2.getPercentage(), e1.getPercentage());
	}
}


enum Gender{
	MALE,
	FEMALE
}

class Student{
	private int rollNo;
	private String name;
	private int age;
	private int standard;
	private String school;
	private Gender gender;
	private double percentage;
	private Fees fees;	

	public Student(int r, String n, int a, int st, String sc, String g, Double p, Fees f){
		rollNo = r;
		name = n;
		age = a;
		standard = st;
		school = sc;
		gender = Gender.valueOf(g);
		percentage = p;
		fees = f;
	}

	public int getRollNo(){
		return rollNo;
	}

	public String getName(){
		return name;
	}

	public int getAge(){
		return age;
	}
		
	public int getStandard(){
		return standard;
	}

	public String getSchool(){
		return school;
	}
	
	public String getGender(){
		return gender.toString();
	}

	public double getPercentage(){
		return percentage;
	}

	public Fees getFees(){
		return fees;
	}

	public String toString(){
		return "\n{\n\tRollNO = "+rollNo+", \n\tName = "+name+", \n\tAge = "+age+", \n\tStandard = "+standard+", \n\tSchool = "+school+", \n\tGender = "+gender+", \n\tPercentage = "+percentage+", \n\tFees : \n\t\t{ \n\t\t\tTotalFees : "+fees.getTotalFees()+", \n\t\t\t Fees Paid : "+fees.getFeesPaid()+", \n\t\t\tFees Pending = "+fees.getFeesPending()+"\n\t\t}"+"\n}\n";
	}

}

class Fees{
	private long totalFees;
	private long feesPaid;
	private long feesPending;
	
	public Fees(long t, long p){
		totalFees = t;
		feesPaid = p;
		feesPending = t - p;
	}

	
	public long getTotalFees(){
		return totalFees;
	}

	public long getFeesPaid(){
		return feesPaid;
	}

	public long getFeesPending(){
		return feesPending;
	}
}