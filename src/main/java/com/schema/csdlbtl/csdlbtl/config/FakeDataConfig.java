// package com.schema.csdlbtl.csdlbtl.config;
//
// import java.time.LocalDate;
// import java.time.ZoneId;
// import java.util.*;
//
// import javax.transaction.Transactional;
//
// import com.schema.csdlbtl.csdlbtl.entity.*;
// import com.schema.csdlbtl.csdlbtl.entity.id.*;
// import com.schema.csdlbtl.csdlbtl.repository.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;
//
// import com.github.javafaker.Faker;
//
// @Component
// public class FakeDataConfig implements CommandLineRunner {
//     private static Faker faker = new Faker(new Locale("vi"));
//
//     @Autowired
//     private UserRepository userRepository;
//
//     @Autowired
//     private StaffRepository staffRepository;
//
//     @Autowired
//     private AdminRepository adminRepository;
//
//     @Autowired
//     private TutorRepository tutorRepository;
//
//     @Autowired
//     private TutorApplicationRepository tutorApplicationRepository;
//
//     @Autowired
//     private StudentRepository studentRepository;
//
//     @Autowired
//     private EducationalInstitutionRepository educationalInstitutionRepository;
//
//     @Autowired
//     private ConsultationReqRepository consultationReqRepository;
//
//     @Autowired
//     private CertificateTypeRepository certificateTypeRepository;
//
//     @Autowired
//     private WeekDayRepository weekDayRepository;
//
//     @Autowired
//     private ClassTypeRepository classTypeRepository;
//
//     @Autowired
//     private SubjectRepository subjectRepository;
//
//     @Autowired
//     private TeachingStyleRepository teachingStyleRepository;
//
//     @Autowired
//     private TimeSlotRepository timeSlotRepository;
//
//     @Autowired
//     private WardRepository wardRepository;
//
//     @Autowired
//     private ProvinceRepository provinceRepository;
//
//     @Autowired
//     private DistrictRepository districtRepository;
//
//     @Autowired
//     private AddressRepository addressRepository;
//
//     @Autowired
//     private ClassessRepository classessRepository;
//
//     public static String generateRandomCitizenID() {
//         Random random = new Random();
//
//         StringBuilder cccdBuilder = new StringBuilder();
//
//         for (int i = 0; i < 12; i++) {
//             int digit = random.nextInt(10); // số ngẫu nhiên từ 0 đến 9
//             cccdBuilder.append(digit);
//         }
//
//         return cccdBuilder.toString();
//     }
//
//     public static Date randomDateOfBirth(int minAge, int maxAge) {
//         LocalDate today = LocalDate.now();
//         LocalDate startDate = today.minusYears(maxAge);
//         LocalDate endDate = today.minusYears(minAge);
//
//         LocalDate randomDate = faker.date().between(java.sql.Date.valueOf(startDate), java.sql.Date.valueOf(endDate))
//                 .toInstant()
//                 .atZone(ZoneId.systemDefault()).toLocalDate();
//
//         return Date.from(randomDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
//     }
//
//     @Override
//     @Transactional
//     public void run(String... args) throws Exception {
//         Random random = new Random();
//
//         // Mảng Tutor
//         List<Tutor> tutors = new ArrayList<>();
//
//         // Mảng disable Tutor
//         List<Integer> number = new ArrayList<>();
//
//         // Lấy trường học ngẫu nhiên
//         List<String> schools = Arrays.asList(
//                 "Trường Mầm Non Hoa Sen",
//                 "Trường Tiểu Học Nguyễn Huệ",
//                 "Trường Trung Học Cơ Sở Trần Phú",
//                 "Trường Trung Học Cơ Sở Lý Tự Trọng",
//                 "Trường Trung Học Phổ Thông Nguyễn Trãi",
//                 "Trường Đại Học Bách Khoa",
//                 "Trường Đại Học Khoa Học Tự Nhiên",
//                 "Trường Đại Học Sư Phạm",
//                 "Trường Đại Học Y Dược",
//                 "Trường Trung Học Phổ Thông Chu Văn An");
//         /**
//          * ******** Fake Degree Institution *********
//          * ******************************************
//          * ******************************************
//          */
//         String[] listInstitution = { "Giáo dục mầm non", "Giáo dục cấp tiểu học", "Giáo dục cấp trung học",
//                 "Giáo dục cấp phổ thông", "Giáo dục cấp đại học và sau đại học" };
//         for (String ins : listInstitution) {
//             educationalInstitutionRepository.save(EducationalInstitution.builder().ediName(ins).build());
//         }
//
//         /**
//          * ************ Fake Time Slot  *************
//          * ******************************************
//          * ******************************************
//          */
//         Integer startTime[] = {7,8,9,10,11,12,13,14,15,16,17,18,19,20};
//         for (Integer time : startTime) {
//             Date startDate = new Date(2024, 11, 9,time, 0, 0);
//             Date endDate = new Date(2024, 11,9,time + 2, 0, 0);
//             timeSlotRepository.save(TimeSlot.builder().startTime(startDate).endTime(endDate).build());
//         }
//
//         /**
//          * ********** Fake Teaching Style ***********
//          * ******************************************
//          * ******************************************
//          */
//         teachingStyleRepository.save(TeachingStyle.builder().tsName("Trực tuyến").build());
//         teachingStyleRepository.save(TeachingStyle.builder().tsName("Trực tiếp").build());
//
//         /**
//          * ************ Fake Class Type *************
//          * ******************************************
//          * ******************************************
//          */
//         String listClassType[] = {"Lớp Lá", "Lớp 1", "Lớp 2", "Lớp 3", "Lớp 4", "Lớp 5", "Lớp 6", "Lớp 7", "Lớp 8", "Lớp 9", "Lớp 10", "Lớp 11", "Lớp 12", "Ôn Thi Đại Học", "Dạy Song Ngữ", "Dạy Bằng Tiếng Anh", "Ôn Trần Đại Nghĩa", "Ôn Thi Trường Chuyên", "Dạy Trẻ Tự Kỷ"};
//         for(String classType : listClassType) {
//             classTypeRepository.save(ClassType.builder().classTypeName(classType).build());
//         }
//
//         /**
//          * ************* Fake Subject ***************
//          * ******************************************
//          * ******************************************
//          */
//         String listSubject[] = {
//            "Toán", "Lý", "Hóa", "Văn", "Tiếng Việt", "Anh Văn", "Báo Bài", "Sinh", "Sử", "Địa",
//                 "Tin Học", "Vẽ", "Rèn Chữ", "Anh Văn Giao Tiếp", "TOEIC", "IELTS", "TOEFL",
//                 "Tiếng Pháp", "Tiếng Hàn", "Tiếng Hoa", "Tiếng Nhật", "Đàn Piano", "Đàn Organ",
//                 "Đàn Guitar", "Tiếng Việt Cho Người Nước Ngoài", "Nhảy Hiện Đại", "Khoa Học Tự Nhiên",
//                 "Khoa Học"
//         };
//         for(String subject : listSubject) {
//             subjectRepository.save(Subject.builder().subjectName(subject).build());
//         }
//
//         /**
//          * ************* Fake Province **************
//          * ******************************************
//          * ******************************************
//          */
//         String listProvince[] = {
//                 "Hà Nội", "Hồ Chí Minh", "Đà Nẵng", "Hải Phòng", "Cần Thơ",
//                 "Huế", "Nha Trang", "Vũng Tàu", "Đà Lạt", "Quy Nhơn"
//         };
//         for(String province : listProvince) {
//             provinceRepository.save(Province.builder().provinceName(province).build());
//         }
//
//         /**
//          * ************* Fake District **************
//          * ******************************************
//          * ******************************************
//          */
//         String listDistrict[][] = {
//                 {
//                     "Hoàn Kiếm", "Ba Đình", "Đống Đa"
//                 },
//                 {
//                     "Quận 1", "Quận 2", "Quận 3", "Quận 4", "Quận 5", "Quận 6", "Quận 7", "Quận 8", "Quận 9",
//                         "Quận 10", "Quận 11", "Quận 12", "Bình Thạnh", "Tân Bình", "Tân Phú", "Gò Vấp",
//                         "Phú Nhuận", "Bình Tân", "Nhà Bè", "Hóc Môn", "Cần Giờ"
//                 },
//                 {
//                     "Hải Châu", "Sơn Trà", "Ngũ Hành Sơn"
//                 },
//                 {
//                     "Lê Chân", "Hải An", "Đồ Sơn"
//                 },
//                 {
//                     "Ninh Kiều", "Bình Thủy", "Cái Răng"
//                 },
//                 {
//                     "Thành Phố Huế", "Hương Thủy", "Hương Trà"
//                 },
//                 {
//                     "Thành Phố Nha Trang", "Vĩnh Nguyên", "Vĩnh Hải"
//                 },
//                 {
//                     "Thành Phố Vũng Tàu", "Châu Đức", "Long Điền"
//                 },
//                 {
//                         "Thành Phố Đà Lạt", "Lạc Dương", "Đơn Dương"
//                 },
//                 {
//                     "Thành Phố Quy Nhơn", "Hoài Nhơn", "Phù Mỹ"
//                 }
//         };
//         Long countProvince = 1L;
//         for(String[] districtOfProvinces : listDistrict) {
//             for (String district : districtOfProvinces) {
//                 districtRepository.save(District.builder().districtName(district)
//                         .id(DistrictId.builder().province(provinceRepository
//                                 .getById(countProvince)).build()).build());
//             }
//             countProvince++;
//         }
//
//         String listWardHCM[][] = {
//                 {
//                     "Phường Bến Nghé", "Phường Bến Thành", "Phường Nguyễn Thái Bình"
//                 },
//                 {
//                     "Phường Thảo Điền", "Phường An Phú", "Phường Bình An"
//                 },
//                 {
//                     "Phường Võ Thị Sáu", "Phường Đa Kao", "Phường Nguyễn Thiện Thuật"
//                 },
//                 {
//                     "Phường 1", "Phường 2", "Phường 3"
//                 },
//                 {
//                         "Phường 1", "Phường 2", "Phường 3"
//                 },
//                 {
//                         "Phường 1", "Phường 2", "Phường 3"
//                 },
//                 {
//                     "Phường Tân Phú", "Phường Tân Quy", "Phường Bình Thuận"
//                 },
//                 {
//                         "Phường 1", "Phường 2", "Phường 3"
//                 },
//                 {
//                     "Phường Hiệp Phú", "Phường Long Bình", "Phường Tân Phú"
//                 },
//                 {
//                         "Phường 1", "Phường 2", "Phường 3"
//                 },
//                 {
//                         "Phường 1", "Phường 2", "Phường 3"
//                 },
//                 {
//                     "Phường Hiệp Thành", "Phường Thạnh Lộc", "Phường Tân Thới Nhất"
//                 },
//                 {
//                     "Phường 11", "Phường 17", "Phường 19"
//                 },
//                 {
//                         "Phường 1", "Phường 2", "Phường 3"
//                 },
//                 {
//                     "Phường Tân Sơn Nhì", "Phường Tân Thới Nhất", "Phường Hiệp Tân"
//                 },
//                 {
//                         "Phường 1", "Phường 2", "Phường 3"
//                 },
//                 {
//                         "Phường 1", "Phường 2", "Phường 3"
//                 },
//                 {
//                     "Phường Bình Hưng Hòa", "Phường Bình Trị Đông", "Phường Tân Tạo"
//                 },
//                 {
//                     "Phường Nhơn Đức", "Phường Phước Kiểng", "Phường Tân Quy"
//                 },
//                 {
//                     "Xã Bà Điểm", "Xã Đông Thạnh", "Xã Nhị Bình"
//                 },
//                 {
//                     "Xã An Thới Đông", "Xã Bình Khánh", "Xã Cần Thạnh"
//                 }
//         };
//         int countWard = 0;
//         for(String[] wardOfDistricts : listWardHCM) {
//             for (String ward : wardOfDistricts) {
//                 wardRepository.save(Ward.builder().wardName(ward).id(WardId.builder().district(districtRepository.findByDistrictName(listDistrict[1][countWard])).build()).build());
//             }
//             countWard++;
//         }
//
//         /**
//          * ************* Fake Weekday ***************
//          * ******************************************
//          * ******************************************
//          */
//
//         String[] listWeekday = { "Thứ hai", "Thứ ba", "Thứ tư", "Thứ năm", "Thứ sáu", "Thứ bảy", "Chủ nhật" };
//         for (String day : listWeekday) {
//             weekDayRepository.save(WeekDay.builder().name(day).build());
//         }
//
//         /**
//          * ********* Fake Certificate Type **********
//          * ******************************************
//          * ******************************************
//          */
//
//         String[] listCertificateType = { "Chứng chỉ CCNA", "Chứng chỉ CCIE", "Chứng chỉ CISM", "Chứng chỉ CISA",
//                 "Chứng chỉ CISSP", "Chứng chỉ CRISC", "Chứng chỉ MCITP", "Chứng chỉ MCTS", "Chứng chỉ MCPD",
//                 "Chứng chỉ MCSE và MCSA" };
//         for (String cerType : listCertificateType) {
//             certificateTypeRepository.save(CertificateType.builder().ctName(cerType).build());
//         }
//
//         /**
//          * *************** Fake User ****************
//          * ******************************************
//          * ******************************************
//          */
//         for (int i = 0; i < 100; i++) {
//             User user = new User();
//             user.setFullname(faker.name().fullName());
//             user.setPhoneNumber(faker.phoneNumber().phoneNumber());
//             user.setSex(faker.options().option("Nam", "Nữ"));
//             user.setPassword("321323");
//
//             /**
//              * *************** Fake Address *************
//              * ******************************************
//              * ******************************************
//              */
//             int randNumAddress = random.nextInt(1,6);
//             List<Address> addresses = new ArrayList<>();
//             for (int j = 0; j < randNumAddress; j ++ ){
//                 int x = random.nextInt(0, listWardHCM.length);
//                 int y = random.nextInt(0, listWardHCM[x].length);
//                 List<Ward> wards = wardRepository.findByWardName(listWardHCM[x][y]);
//                 addresses.add(Address.builder().houseNumber(Integer.valueOf(faker.address().buildingNumber()))
//                         .user(user).streetName(faker.address().streetName()).ward(wards.get(random.nextInt(0, wards.size()))).build());
//             }
//             user.setAddresses(addresses);
//             userRepository.save(user);
//
//             Object object = faker.options().option(new Student(), new Tutor(), new Admin());
//
//             /**
//              * ************* Fake Student ***************
//              * ******************************************
//              * ******************************************
//              */
//
//             Student student = new Student();
//             student.setStuGrade(faker.options().option(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
//             student.setStuSchool(schools.get(random.nextInt(schools.size())));
//             student.setId(StudentId.builder().user(user).build());
//
//             /**
//              * ************** Fake Staff ****************
//              * ******************************************
//              * ******************************************
//              */
//
//             Staff staff = new Staff();
//             staff.setNationalId(generateRandomCitizenID());
//             staff.setPlaceOfOrigin(faker.address().cityName() + "," + faker.address().country());
//             staff.setDateOfBirth(randomDateOfBirth(6, 20));
//             staff.setProfilePhoto(faker.lorem().characters().getBytes());
//             staff.setId(StaffId.builder().user(user).build());
//             if(object instanceof Tutor || object instanceof Admin){
//                 staffRepository.save(staff);
//             }
//
//             /**
//              * ************** Fake Tutor ****************
//              * ******************************************
//              * ******************************************
//              */
//
//             Tutor tutor = new Tutor();
//             tutor.setBio(faker.lorem().characters());
//             tutor.setRate(faker.options().option(0, 1, 2, 3, 4, 5));
//             tutor.setInvitingCode(generateRandomCitizenID());
//             tutor.setNOfInvitations(random.nextInt(1000));
//             tutor.setDateJoined(randomDateOfBirth(0, 3));
//             tutor.setId(TutorId.builder().staff(staff).build());
//
//             /**
//              * ********** Fake Can Teach Style **********
//              * ******************************************
//              * ******************************************
//              */
//             Long randStyle1 = random.nextLong(1, 3);
//             Long randStyle2 = random.nextLong(1, 3);
//             List<TeachingStyle> styles = new ArrayList<>();
//             if(randStyle1.equals(randStyle2)){
//                 styles.add(teachingStyleRepository.findById(randStyle1).get());
//             } else {
//                 styles.add(teachingStyleRepository.findById(randStyle2).get());
//                 styles.add(teachingStyleRepository.findById(randStyle1).get());
//             }
//             tutor.setTeachingStyles(styles);
//
//             /**
//              * ********** Fake Can Teach Type ***********
//              * ******************************************
//              * ******************************************
//              */
//
//             Long randClassTypeNum = random.nextLong(1, listClassType.length + 1);
//             List<ClassType> classTypes = new ArrayList<>();
//             List<Long> classTypeDisableList = new ArrayList<>();
//             for (int j = 0; j < randClassTypeNum; j ++ ){
//                 Long idxClassType;
//                 do {
//                     idxClassType = random.nextLong(1, listClassType.length + 1);
//                 }while(classTypeDisableList.contains(idxClassType));
//                 classTypeDisableList.add(idxClassType);
//                 classTypes.add(classTypeRepository.findById(idxClassType).get());
//             }
//             tutor.setClassTypes(classTypes);
//
//             /**
//              * ************* Fake Can Teach *************
//              * ******************************************
//              * ******************************************
//              */
//
//             Long randSubjectNum = random.nextLong(1, listSubject.length + 1);
//             List<Subject> subjects = new ArrayList<>();
//             List<Long> subjectDisableList = new ArrayList<>();
//             for (int j = 0; j < randSubjectNum; j ++ ){
//                 Long idxSubject;
//                 do {
//                     idxSubject = random.nextLong(1, listSubject.length + 1);
//                 }while(subjectDisableList.contains(idxSubject));
//                 subjectDisableList.add(idxSubject);
//                 subjects.add(subjectRepository.findById(idxSubject).get());
//             }
//             tutor.setSubjects(subjects);
//
//             /**
//              * *********** Fake Can Teach At ************
//              * ******************************************
//              * ******************************************
//              */
//             Long randomDistrictsNum = random.nextLong(0, 4);
//             List<District> districts = new ArrayList<>();
//             List<String> nameDistrictsDisable = new ArrayList<>();
//             for (int j = 0; j < randomDistrictsNum; j++) {
//                 int x, y;
//                 do {
//                     x = random.nextInt(0, listDistrict.length);
//                     y = random.nextInt(0, listDistrict[x].length);
//                 }while(nameDistrictsDisable.contains(listDistrict[x][y]));
//                 nameDistrictsDisable.add(listDistrict[x][y]);
//                 districts.add(districtRepository.findByDistrictName(listDistrict[x][y]));
//             }
//             tutor.setDistricts(districts);
//
//             /**
//              * *********** Fake Graduated From **********
//              * ******************************************
//              * ******************************************
//              */
//
//             int rdn = random.nextInt(1, 5);
//             List<EducationalInstitution> educationalInstitutions = new ArrayList<>();
//             List<Long> listEIDisable = new ArrayList<Long>();
//             for (int j = 0; j < rdn; j++) {
//                 Long eiIdxRand;
//                 do{
//                     eiIdxRand = random.nextLong(1, 6);
//                 }while(listEIDisable.contains(eiIdxRand));
//                 educationalInstitutions.add(educationalInstitutionRepository.findById(eiIdxRand).get());
//                 listEIDisable.add(eiIdxRand);
//             }
//
//             tutor.setEducationalInstitutions(educationalInstitutions);
//
//             int rd = random.nextInt(0, tutors.size() + 1);
//             Integer numRandTutor;
//             for (int j = 0; j < rd; j++) {
//                 do {
//                     numRandTutor = random.nextInt(0, tutors.size());
//                 } while (number.contains(numRandTutor));
//                 number.add(numRandTutor);
//                 tutor.setInvitedCode(tutors.get(numRandTutor));
//             }
//             number.clear();
//
//             /**
//              * *************** Fake Degree **************
//              * ******************************************
//              * ******************************************
//              */
//             int randomDegreeNumber = random.nextInt(0, 4);
//             List<Degree> degrees = new ArrayList<>();
//             List<Long> insTitutionDisable = new ArrayList<>();
//             for (int j = 0; j < randomDegreeNumber; j++) {
//                 Long randDisableInstitu;
//                 do{
//                     randDisableInstitu = random.nextLong(1, 6);
//                 }while(insTitutionDisable.contains(randDisableInstitu));
//                 degrees.add(Degree.builder().id(DegreeId.builder().tutor(tutor).build())
//                         .degrMajorName(faker.educator().course()).degrType(faker.options()
//                                 .option("Cử nhân", "Thạc sĩ", "Tiến sĩ", "Cao đẳng"))
//                         .degrYear(random.nextInt(2000, 2024))
//                         .educationalInstitution(educationalInstitutionRepository.findById(randDisableInstitu).get()).build());
//                 insTitutionDisable.add(randDisableInstitu);
//             }
//             tutor.setDegrees(degrees);
//
//             /**
//              * *********** Fake Qualification ***********
//              * ******************************************
//              * ******************************************
//              */
//
//             int nRan = random.nextInt(1, 4);
//             List<Qualification> qualifications = new ArrayList<>();
//             for (int j = 0; j < nRan; j++) {
//                 qualifications
//                         .add(Qualification.builder().qualificationId(QualificationId.builder().tutor(tutor).qualification(faker.lorem().characters(1, 30)).build()).build());
//             }
//             tutor.setQualifications(qualifications);
//
//               /**
//              * ************ Fake Certificate ************
//              * ******************************************
//              * ******************************************
//              */
//             int randomm1 = random.nextInt(0, listCertificateType.length + 1);
//             List<Certificate> certificates = new ArrayList<>();
//             List<Long> cerDisable = new ArrayList<>();
//             for(int j = 0; j < randomm1; j++) {
//                 Long rancerTutor;
//                 do {
//                     rancerTutor = (long) random.nextInt(1, listCertificateType.length + 1);
//                 }while(cerDisable.contains(rancerTutor));
//                 cerDisable.add(rancerTutor);
//                 certificates.add(Certificate.builder().certificateType(certificateTypeRepository
//                                 .findById(rancerTutor).get()).certGrade(Integer.toString(random.nextInt(300, 1000)))
//                         .cerYear(random.nextInt(2000, 2024))
//                         .id(CertificateId.builder().tutor(tutor).build()).build());
//             }
//             tutor.setCertificates(certificates);
//
//             /**
//              * ************** Fake Admin ****************
//              * ******************************************
//              * ******************************************
//              */
//
//             Admin admin = new Admin();
//              admin.setId(AdminId.builder().staff(staff).build());
//
//              // list address
//             List<Address> addressListUser = addressRepository.findByUser(user);
//             List<Address> allAddresses = addressRepository.findAll();
//             List<Student> allStudents = studentRepository.findAll();
//             List<TeachingStyle> allTeachingStyles = teachingStyleRepository.findAll();
//             Long randNumReq = random.nextLong(0, 5);
//             if (object instanceof Admin) {
//                 adminRepository.save(admin);
//              } else if (object instanceof Tutor) {
//                tutorRepository.save(tutor);
//                tutors.add(tutor);
//                 if(allAddresses.size() > 0 && allStudents.size() > 0 && allTeachingStyles.size() > 0) {
//                     for (int j = 0; j < randNumReq; j++){
//                         int randAddr = random.nextInt(0, allAddresses.size());
//                         int randStu = random.nextInt(0, allStudents.size());
//                         int randTeach = random.nextInt(0, allTeachingStyles.size());
//                         /**
//                          * *********** Fake Ta Want Type ************
//                          * ******************************************
//                          * ******************************************
//                          */
//
//                         Long randClassTypeTANum = random.nextLong(1, listClassType.length + 1);
//                         List<ClassType> classTypeTAs = new ArrayList<>();
//                         List<Long> classTypeDisableListTA = new ArrayList<>();
//                         for (int k = 0; k < randClassTypeTANum; k ++ ){
//                             Long idxClassTypeTA;
//                             do {
//                                 idxClassTypeTA = random.nextLong(1, listClassType.length + 1);
//                             }while(classTypeDisableListTA.contains(idxClassTypeTA));
//                             classTypeDisableListTA.add(idxClassTypeTA);
//                             classTypeTAs.add(classTypeRepository.findById(idxClassTypeTA).get());
//                         }
//
//                         /**
//                          * ********** Fake Ta Want Subject **********
//                          * ******************************************
//                          * ******************************************
//                          */
//
//                         Long randSubjectNumTA = random.nextLong(1, listSubject.length + 1);
//                         List<Subject> subjectTAs = new ArrayList<>();
//                         List<Long> subjectDisableListTA = new ArrayList<>();
//                         for (int k = 0; k < randSubjectNumTA; k ++ ){
//                             Long idxSubjectTA;
//                             do {
//                                 idxSubjectTA = random.nextLong(1, listSubject.length + 1);
//                             }while(subjectDisableListTA.contains(idxSubjectTA));
//                             subjectDisableListTA.add(idxSubjectTA);
//                             subjectTAs.add(subjectRepository.findById(idxSubjectTA).get());
//                         }
//                         tutorApplicationRepository.save(
//                                 TutorApplication.builder().address(allAddresses.get(randAddr))
//                                         .tutor(tutor)
//                                         .student(allStudents.get(randStu))
//                                         .requirement(faker.lorem().paragraph(3))
//                                         .taStatus(faker.options().option("Đã duyệt", "Từ chối", "Đang chờ"))
//                                         .teachingStyle(allTeachingStyles.get(randTeach))
//                                         .classTypes(classTypeTAs)
//                                         .subjects(subjectTAs)
//                                         .build()
//                         );
//                     }
//                 }
//              } else {
//                studentRepository.save(student);
//                 /**
//                  * ********** Fake Can Teach Style **********
//                  * ******************************************
//                  * ******************************************
//                  */
//                 Long randStyleReq1 = random.nextLong(1, 3);
//                 Long randStyleReq2 = random.nextLong(1, 3);
//                 List<TeachingStyle> styleReqs = new ArrayList<>();
//                 if(randStyleReq1.equals(randStyleReq2)){
//                     styleReqs.add(teachingStyleRepository.findById(randStyleReq1).get());
//                 } else {
//                     styleReqs.add(teachingStyleRepository.findById(randStyleReq2).get());
//                     styleReqs.add(teachingStyleRepository.findById(randStyleReq1).get());
//                 }
//
//                 /**
//                  * ********** Fake Can Teach Type ***********
//                  * ******************************************
//                  * ******************************************
//                  */
//
//                 Long randClassTypeReqNum = random.nextLong(1, listClassType.length + 1);
//                 List<ClassType> classTypeReqs = new ArrayList<>();
//                 List<Long> classTypeDisableListReq = new ArrayList<>();
//                 for (int j = 0; j < randClassTypeReqNum; j ++ ){
//                     Long idxClassTypeReq;
//                     do {
//                         idxClassTypeReq = random.nextLong(1, listClassType.length + 1);
//                     }while(classTypeDisableListReq.contains(idxClassTypeReq));
//                     classTypeDisableListReq.add(idxClassTypeReq);
//                     classTypeReqs.add(classTypeRepository.findById(idxClassTypeReq).get());
//                 }
//
//                 /**
//                  * ************* Fake Can Teach *************
//                  * ******************************************
//                  * ******************************************
//                  */
//
//                 Long randSubjectNumReq = random.nextLong(1, listSubject.length + 1);
//                 List<Subject> subjectReqs = new ArrayList<>();
//                 List<Long> subjectDisableListReq = new ArrayList<>();
//                 for (int j = 0; j < randSubjectNumReq; j ++ ){
//                     Long idxSubjectReq;
//                     do {
//                         idxSubjectReq = random.nextLong(1, listSubject.length + 1);
//                     }while(subjectDisableListReq.contains(idxSubjectReq));
//                     subjectDisableListReq.add(idxSubjectReq);
//                     subjectReqs.add(subjectRepository.findById(idxSubjectReq).get());
//                 }
//                for(int j = 0; j < randNumReq; j++) {
//                    int randAddressStudent = random.nextInt(0, addressListUser.size());
//                    ConsultationReq consultationReq = ConsultationReq.builder().student(student)
//                            .cqStatus(faker.options().option("Đã duyệt", "Từ chối", "Đang chờ"))
//                            .address(addressListUser.get(randAddressStudent))
//                            .requirements(faker.lorem().characters(10, 30))
//                            .subjects(subjectReqs)
//                            .classTypes(classTypeReqs)
//                            .teachingStyles(styleReqs)
//                            .build();
//                    consultationReqRepository.save(consultationReq);
//                }
//              }
//         }
//
//         /**
//          * *************** Fake Class ***************
//          * ******************************************
//          * ******************************************
//          */
//         List<Address> addresses = addressRepository.findAll();
//         List<Student> students = studentRepository.findAll();
//         List<TeachingStyle> teachingStyles = teachingStyleRepository.findAll();
//         List<Tutor> tutors1 = tutorRepository.findAll();
//         for (int i = 0; i < 50; i ++){
//             Integer randAddress = random.nextInt(0, addresses.size());
//             Integer randStudent = random.nextInt(0, students.size());
//             Integer randTeachingStyle = random.nextInt(0, teachingStyles.size());
//             Integer randTutor = random.nextInt(0, tutors1.size());
//             /**
//              * ********** Fake Has Class Type ***********
//              * ******************************************
//              * ******************************************
//              */
//
//             Long randClassTypeClassNum = random.nextLong(1, listClassType.length + 1);
//             List<ClassType> classTypeClasses = new ArrayList<>();
//             List<Long> classTypeDisableListClass = new ArrayList<>();
//             for (int j = 0; j < randClassTypeClassNum; j ++ ){
//                 Long idxClassTypeClass;
//                 do {
//                     idxClassTypeClass = random.nextLong(1, listClassType.length + 1);
//                 }while(classTypeDisableListClass.contains(idxClassTypeClass));
//                 classTypeDisableListClass.add(idxClassTypeClass);
//                 classTypeClasses.add(classTypeRepository.findById(idxClassTypeClass).get());
//             }
//
//             /**
//              * *********** Fake Has  Subject ************
//              * ******************************************
//              * ******************************************
//              */
//
//             Long randSubjectNumClass = random.nextLong(1, listSubject.length + 1);
//             List<Subject> subjectClasses = new ArrayList<>();
//             List<Long> subjectDisableListClass = new ArrayList<>();
//             for (int j = 0; j < randSubjectNumClass; j ++ ){
//                 Long idxSubjectClass;
//                 do {
//                     idxSubjectClass = random.nextLong(1, listSubject.length + 1);
//                 }while(subjectDisableListClass.contains(idxSubjectClass));
//                 subjectDisableListClass.add(idxSubjectClass);
//                 subjectClasses.add(subjectRepository.findById(idxSubjectClass).get());
//             }
//             classessRepository.save(
//                     Classess.builder().address(addresses.get(randAddress))
//                             .student(students.get(randStudent))
//                             .tutor(tutors1.get(randTutor))
//                             .teachingStyle(teachingStyles.get(randTeachingStyle))
//                             .commistionFee(generateRandomCommissionFee(faker, 1.0, 10.0))
//                             .requirement(faker.lorem().paragraph(4))
//                             .classDeposit(generateRandomCommissionFee(faker, 500000, 1000000))
//                             .salary(generateRandomCommissionFee(faker, 10000000, 30000000))
//                             .classStatus(faker.options().option( "Chưa nhận", "Đã nhận", "Đã đóng tiền cọc", "Đã hủy", "Kết thúc khóa"))
//                             .subjects(subjectClasses)
//                             .classTypes(classTypeClasses)
//                             .build()
//             );
//             Classess classess = classessRepository.findById(i + 1L).get();
//             List<TimeSlot> timeSlots = timeSlotRepository.findAll();
//             List<WeekDay> weekDays = weekDayRepository.findAll();
//             List<IsHeldOn> isHeldOns = new ArrayList<>();
//             List<Integer> randWeekDayDis = new ArrayList<>();
//             for(int j = 0; j < 3; j ++ ){
//                 Integer idxTimeSlot;
//                 Integer idxWeekDay;
//                 do {
//                     idxWeekDay = random.nextInt(0, weekDays.size());
//                     idxTimeSlot = random.nextInt(0, timeSlots.size());
//                 }while(randWeekDayDis.contains(idxWeekDay));
//                 randWeekDayDis.add(idxWeekDay);
//                 isHeldOns.add(IsHeldOn.builder().id(IsHeldOnId.builder()
//                         .classess(classess)
//                         .timeSlot(timeSlots.get(idxTimeSlot))
//                         .weekDay(weekDays.get(idxWeekDay)).build())
//                         .build());
//             }
//             classess.setIsHeldOns(isHeldOns);
//             classessRepository.save(classess);
//         }
//
//         /**
//          * *************** Fake Voucher *************
//          * ******************************************
//          * ******************************************
//          */
//
//         for (int j = 0; j < 50; j ++){
//             Tutor voucherTutor = tutors1.get(random.nextInt(0, tutors1.size()));
//             List<Tutor> tutors2 = tutorRepository.findByInvitings(voucherTutor);
//             List<Voucher> vouchers = new ArrayList<>();
//             for (int u = 0; u < tutors2.size(); u ++ ){
//                 vouchers.add(Voucher.builder().tutor(voucherTutor)
//                         .vouDiscount(faker.options().option(5L, 10L, 15L, 20L, 25L, 30L))
//                         .vouStatus(faker.options().option("Đã sử dụng", "Chưa sử dụng"))
//                         .build());
//             }
//             voucherTutor.getVouchers().addAll(vouchers);
//             tutorRepository.save(voucherTutor);
//             vouchers.clear();
//         }
//
//         /**
//          * ************ Fake Tutor Review ***********
//          * ******************************************
//          * ******************************************
//          */
//         List<Integer> randStuDisable = new ArrayList<>();
//         List<Integer> randClassDisable = new ArrayList<>();
//         List<Classess> classesses = new ArrayList<>();
//         for (int i = 0; i < 50; i ++){
//             int randStudent, randClass = 0;
//             do {
//                 randStudent = random.nextInt(0, students.size());
//                 classesses = classessRepository.findByStudent(students.get(randStudent));
//                 if(classesses.size() == 0){
//                     break;
//                 }
//                 randClass = random.nextInt(0, classesses.size());
//             }while(randClassDisable.contains(randClass) && randStuDisable.contains(randStudent));
//             if(classesses.size() != 0){
//                 randClassDisable.add(randClass);
//                 randStuDisable.add(randStudent);
//                 TutorReview review = TutorReview.builder().student(students.get(randStudent))
//                         .classess(classesses.get(randClass))
//                         .rate(random.nextInt(1, 6))
//                         .comment(faker.lorem().paragraph(2))
//                         .time_stamp(new Date())
//                         .build();
//                 students.get(randStudent).getTutorReviews().add(review);
//                 studentRepository.save(students.get(randStudent));
//             }
//             classesses = new ArrayList<>();
//         }
//
//         for(int j = 0; j < tutors1.size(); j++ ){
//             Integer randTutorApply = random.nextInt(0, tutors1.size());
//             List<Classess> classesses1 = classessRepository.findByTutor(tutors1.get(randTutorApply));
//             Integer randClass = random.nextInt(0, classesses1.size());
//
//         }
//     }
//
//     public static Long generateRandomCommissionFee(Faker faker, double min, double max) {
//         return (long) (min + (max - min) * faker.random().nextDouble());
//     }
// }