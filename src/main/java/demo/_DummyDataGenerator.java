package demo;
import java.util.Random;
import java.sql.Date;

import demo.Participant;
import demo.Cohort;
import demo.Address;
import demo.PhoneNum;

public class _DummyDataGenerator {
	// Create dummy data
	public static Cohort[] generateSampleCohortData() throws Exception 
	{
		Cohort[] data = new Cohort[PossibleDescriptions.length];
		
		for (int i=0; i < PossibleDescriptions.length; i++) 
		{
			data[i] = new Cohort(PossibleDescriptions[i]);
		}

        return data;
	}

	private static String[] PossibleDescriptions = {
		"Mass. General Hospital",
		"Florida Hospital",
		"New York-Presbyterian Hospital",
		"Jackson Memorial Hospital", 
		"University of Pittsburgh Medical Center", 
		"Montefiore Medical Center",
		"The Cleveland Clinic",
		"Methodist University Hospital",
		"Barnes-Jewish Hospital",
		"The Mount Sinai Medical Center",
		"Norton Hospital",
		"Erie County Medical Center",
		"Memorial Hermann Southwest Hospital",
		"UAB Hospital",
		"Christiana Hospital",
		"Beaumont Hospital",
		"Spectrum Health Butterworth Hospital",
		"Memorial Regional Hospital",
		"Bergen Regional Medical Center",
		"Beth Israel Medical Center",
		"Ohio State University Hospital",
		"Brookdale University Hospital and Medical Center"
    };
    
	// Create dummy data
	public static Participant[] generateSampleParticipantData(int objectCount) throws Exception 
	{
		Participant[] data = new Participant[objectCount];
		
		for (int i=0; i<objectCount; i++) 
		{
			data[i] = new Participant(randomName(), randomDateOfBirth(), randomAddress(), randomPhoneList());
		}

        return data;
	}

	private static String randomName() {
	    Random rand = new Random();
		return NotableImmunologists[rand.nextInt(NotableImmunologists.length)];
	}

	private static Date randomDateOfBirth() {
		Random rand = new Random();

		int year  = rand.nextInt(100);
		int month = 1+rand.nextInt(11);
		int day = 1+rand.nextInt(27);
		return new Date(year, month, day);
	}
	
	private static String[] NotableImmunologists = {
		"Paul Ehrlich",
		"Bruce A. Beutler",
		"Ralph M. Steinman",
		"Jules Hoffmann", 
		"Alan Aderem", 
		"Lorne Babiuk",
		"William Coley",
		"Yehuda Danon",
		"Deborah Doniach",
		"Eva Engvall",
		"Denise Faustman",
		"William Frankland",
		"Ian Frazer",
		"Samuel O. Freedman",
		"Jules T. Freund",
		"Sankar Ghosh",
		"John Grange",
		"Waldemar Haffkine",
		"Michael Heidelberger",
		"George Heist",
		"Leonard Herzenberg",
		"Miroslav Holub",
		"Charles Janeway",
		"Dermot Kelleher",
		"Tadamitsu Kishimoto",
		"Jan Klein",
		"Mary Loveless",
		"Tak Wah Mak",
		"Polly Matzinger",
		"Ira Mellman",
		"Jacques Miller",
		"Avrion Mitchison",
		"Michael Neuberger",
		"Alan Munro",
		"Gustav Nossal",
		"Santa J. Ono",
		"Thomas Platts-Mills",
		"Nicholas P. Restifo",
		"Fred Rosen",
		"Richard R. Rosenthal",
		"Louis W. Sauer",
		"Emil Skamene",
		"David Talmage",
		"Reyes Tamez",
		"Kevin J. Tracey",
		"Jan Vilcek",
		"Ellen Vitetta",
		"Alexander S. Wiener",
		"Don Wiley",
		"Ian Wilson",
		"Ernst Witebsky",
		"Jian Zhou",
		"Ivan Roitt",
		"James S. Tan",
		"Mike Belosevic",
		"Shimon Sakaguchi",
		"Alberto Mantovani"
	};

	private static Address randomAddress() {
		return new Address(randomStreet(), randomCity(), randomState(), randomZip());
	}

	private static String randomStreet() {
	    Random rand = new Random();
		return "" + rand.nextInt(1000) + " " + CommonStreets[rand.nextInt(CommonStreets.length)];
	}

	private static String[] CommonStreets = {
		"Main Street",
		"Church Street",
		"Main Street North",
		"Main Street South",
		"Elm Street",
		"High Street",
		"Main Street West",
		"Washington Street",
		"Main Street East",
		"Park Avenue",
		"2nd Street",
		"Walnut Street",
		"Chestnut Street",
		"Maple Avenue",
		"Maple Street",
		"Broad Street",
		"Oak Street",
		"Center Street",
		"Pine Street",
		"River Road",
		"Market Street",
		"Water Street",
		"Union Street",
		"South Street",
		"Park Street",
		"3rd Street",
		"Washington Avenue",
		"Cherry Street",
		"North Street",
		"4th Street",
		"Court Street",
		"Highland Avenue",
		"Mill Street",
		"Franklin Street",
		"Prospect Street",
		"School Street",
		"Spring Street",
		"Central Avenue",
		"1st Street",
		"State Street",
		"Front Street",
		"West Street",
		"Jefferson Street",
		"Cedar Street",
		"Jackson Street",
		"Park Place",
		"Bridge Street",
		"Locust Street",
		"Madison Avenue",
		"Meadow Lane",
		"Spruce Street",
		"Grove Street",
		"Ridge Road",
		"5th Street",
		"Pearl Street",
		"Lincoln Street"
	};

	private static String randomCity() {
	    Random rand = new Random();
		return CommonCities[rand.nextInt(CommonCities.length)];
	}

	private static String[] CommonCities = {
		"Washington",
		"Franklin",
		"Arlington",
		"Centerville",
		"Lebanon",
		"Clinton",
		"Springfield",
		"Georgetown",
		"Fairview",
		"Greenville",
		"Bristol",
		"Chester",
		"Dayton",
		"Dover",
		"Madison",
		"Salem",
		"Oakland",
		"Milton",
		"Newport",
		"Riverside",
		"Ashland",
		"Bloomington",
		"Manchester",
		"Oxford",
		"Winchester",
		"Burlington",
		"Jackson",
		"Milford",
		"Clayton",
		"Mount Vernon",
		"Auburn",
		"Kingston",
		"Lexington",
		"Cleveland",
		"Hudson"
	};

	private static String randomState() {
	    Random rand = new Random();
		return CommonStates[rand.nextInt(CommonStates.length)];
	}

	private static String[] CommonStates = {
		"AL",
		"AK",
		"AZ",
		"AR",
		"CA",
		"CO",
		"CT",
		"DE",
		"DC",
		"FL",
		"GA",
		"HI",
		"ID",
		"IL",
		"IN",
		"IA",
		"KS",
		"KY",
		"LA",
		"ME",
		"MD",
		"MA",
		"MI",
		"MN",
		"MS",
		"MO",
		"MT",
		"NE",
		"NV",
		"NH",
		"NJ",
		"NM",
		"NY",
		"NC",
		"ND",
		"OH",
		"OK",
		"OR",
		"PA",
		"RI",
		"SC",
		"SD",
		"TN",
		"TX",
		"UT",
		"VT",
		"VA",
		"WA",
		"WV",
		"WI",
		"WY"
	};

	private static Integer randomZip() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
	
	private static PhoneNum[] randomPhoneList() {
	    Random rand = new Random();
		int l = rand.nextInt(3);
		PhoneNum retval[ ]= new PhoneNum[l];
		for (int i=0; i<l; i++) {
			retval[i]=randomPhoneNum();
		}
		return retval;
	}

	private static PhoneNum randomPhoneNum() {
	    Random rand = new Random();
		int areacode = rand.nextInt(999);
		int exchange = rand.nextInt(999);
		int number = rand.nextInt(9999);
		return new PhoneNum(String.format("(%d) %d-%d", areacode, exchange, number));
	}


	public static String generateRandomResultJson(Integer minId, Integer maxId) {
		String r = "[";

		for (int i = minId; i<maxId; i++) {
			if (i!=minId) {
				r += ", ";
			}
			r += generateRandomTestResult(i);
		}

		r += "]";
		return r;
	}


	/* speciminId, accountNo, street, city, state, zip, 
	patientId, gender,  collectedDate, receivedDate, enteredDate, reportedDate
	result, result2, flag, reference, lab */
	private static String testResultTemplate = "{\"specimenId\": \"%s\", \"accountNumber\": \"%s\", \"labLocation\": { \"nameLine1\": \"LabCorp Test Master\", \"streetAddress\": \"%s\", \"city\": \"%s\", \"state\": \"%s\", \"postalCode\": \"%s\" }, \"patientDetails\": { \"patientId\": %d, \"gender\": \"%s\", \"dob\": \"03/15/1959\" }, \"specimenDetails\": { \"collectedDate\": \"%s\", \"receivedDate\": \"%s\", \"enteredDate\": \"%s\", \"reportedDate\": \"%s\" }, \"clinicalInfo\": \"DETECTED\", \"orderedItems\": [ { \"test\": \"SARS-CoV-2\", \"result\": \"%s\", \"flag\": \"%s\", \"reference\": \"%s\", \"lab\": \"%s\" } ] }";

	public static String generateRandomTestResult(Integer id) {
		String testDate = randomTestDate();
		Boolean result = randomCovidResult();
		return String.format(testResultTemplate, 
							 randomSpeciminId(), 
							 randomAccountNumber(), 
							 randomStreet(), randomCity(), randomState(), randomZip(),
							 id,
							 randomGender(), 
							 testDate, 
							 testDate, 
							 testDate, 
							 testDate,
							 result ? "DETECTED" : "NOT DETECTED",
							 result ? "Detected" : "Not Detected",
							 result ? "Abnormal" : "",
							 resultReference(result),
							 randomLab()
							);
	}

	private static String randomTestDate() 
	{
		Random rand = new Random();
		int month = rand.nextInt(3);
		int day = rand.nextInt(28);
		return String.format("%d/%d/%d", month, day, 2021);
	}

	private static String randomAccountNumber() 
	{
		Random rand = new Random();
		int a = rand.nextInt(999);
		int b = rand.nextInt(999);
		int c = rand.nextInt(999);
		return String.format("%d-%d-%d", a, b, c);
	}

	private static Boolean randomCovidResult()
	{
		Random rand = new Random();
		return rand.nextBoolean();  // TODO - Weigh this?
	}

	private static String randomSpeciminId() {
		Random rand = new Random();
		int a = rand.nextInt(999);
		int b = rand.nextInt(999999);
		return String.format("%d-%d", a, b);
	}

	private static String randomGender()
	{
		Random rand = new Random();
		return rand.nextBoolean() ? "M" : "F";
	}

	private static String resultReference(Boolean result) {
		return "This nucleic acid amplification test was developed and its performance characteristics determined by LabCorp Laboratories. Nucleic acid amplification tests include RT-PCR and TMA. This test has not been FDA cleared or approved. This test has been authorized by FDA under an Emergency Use Authorization (EUA). This test is only authorized for the duration of time the declaration that circumstances exist justifying the authorization of the emergency use of in vitro diagnostic tests for detection of SARS-CoV-2 virus and/or diagnosis of COVID-19 infection under section 564(b)(1) of the Act, 21 U.S.C. 360bbb-3(b) (1), unless the authorization is terminated or revoked sooner. When diagnostic testing is negative, the possibility of a false negative result should be considered in the context of a patient's recent exposures and the presence of clinical signs and symptoms consistent with COVID-19. An individual without symptoms of COVID-19 and who is not shedding SARS-CoV-2 virus would expect to have a negative (not detected) result in this assay.";
	}

	private static String randomLab() {
		Random rand = new Random();
		int a = rand.nextInt(999);
		return String.format("LAB%d", a);
	}

}
