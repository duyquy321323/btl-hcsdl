 package com.schema.csdlbtl.csdlbtl.config;

 import java.time.LocalDate;
 import java.time.ZoneId;
 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.Date;
 import java.util.List;
 import java.util.Random;

 import javax.transaction.Transactional;

 import com.schema.csdlbtl.csdlbtl.entity.id.QualificationId;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.CommandLineRunner;
 import org.springframework.stereotype.Component;

 import com.github.javafaker.Faker;
 import com.schema.csdlbtl.csdlbtl.entity.Admin;
 import com.schema.csdlbtl.csdlbtl.entity.CertificateType;
 import com.schema.csdlbtl.csdlbtl.entity.EducationalInstitution;
 import com.schema.csdlbtl.csdlbtl.entity.Qualification;
 import com.schema.csdlbtl.csdlbtl.entity.Staff;
 import com.schema.csdlbtl.csdlbtl.entity.Student;
 import com.schema.csdlbtl.csdlbtl.entity.Tutor;
 import com.schema.csdlbtl.csdlbtl.entity.User;
 import com.schema.csdlbtl.csdlbtl.repository.AdminRepository;
 import com.schema.csdlbtl.csdlbtl.repository.CertificateTypeRepository;
 import com.schema.csdlbtl.csdlbtl.repository.EducationalInstitutionRepository;
 import com.schema.csdlbtl.csdlbtl.repository.StaffRepository;
 import com.schema.csdlbtl.csdlbtl.repository.StudentRepository;
 import com.schema.csdlbtl.csdlbtl.repository.TutorRepository;
 import com.schema.csdlbtl.csdlbtl.repository.UserRepository;

 @Component
 public class FakeData implements CommandLineRunner {
     private static Faker faker = new Faker();

     @Autowired
     private UserRepository userRepository;

     @Autowired
     private StaffRepository staffRepository;

     @Autowired
     private AdminRepository adminRepository;

     @Autowired
     private TutorRepository tutorRepository;

     @Autowired
     private StudentRepository studentRepository;

     @Autowired
     private EducationalInstitutionRepository educationalInstitutionRepository;

     @Autowired
     private CertificateTypeRepository certificateTypeRepository;

     public static String generateRandomCitizenID() {
         Random random = new Random();

         StringBuilder cccdBuilder = new StringBuilder();

         for (int i = 0; i < 12; i++) {
             int digit = random.nextInt(10); // số ngẫu nhiên từ 0 đến 9
             cccdBuilder.append(digit);
         }

         return cccdBuilder.toString();
     }

     public static Date randomDateOfBirth(int minAge, int maxAge) {
         LocalDate today = LocalDate.now();
         LocalDate startDate = today.minusYears(maxAge);
         LocalDate endDate = today.minusYears(minAge);

         LocalDate randomDate = faker.date().between(java.sql.Date.valueOf(startDate), java.sql.Date.valueOf(endDate))
                 .toInstant()
                 .atZone(ZoneId.systemDefault()).toLocalDate();

         return Date.from(randomDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
     }

     @Override
     @Transactional
     public void run(String... args) throws Exception {
         Random random = new Random();

         // Mảng Tutor
         List<Tutor> tutors = new ArrayList<>();

         // Mảng disable Tutor
         List<Integer> number = new ArrayList<>();

         // Lấy trường học ngẫu nhiên
         List<String> schools = Arrays.asList(
                 "Greenwood High School",
                 "Riverdale Academy",
                 "Sunnydale School",
                 "Lincoln High",
                 "Springfield Secondary",
                 "Hillside International School",
                 "Maplewood College",
                 "Oakridge Public School",
                 "Silver Valley High",
                 "Pinecrest Academy");
         /**
          * ******** Fake Degree Institution *********
          * ******************************************
          * ******************************************
          */
         String[] listInstitution = { "Giáo dục mầm non", "Giáo dục cấp tiểu học", "Giáo dục cấp trung học",
                 "Giáo dục cấp phổ thông", "Giáo dục cấp đại học và sau đại học" };
         for (String ins : listInstitution) {
             educationalInstitutionRepository.save(EducationalInstitution.builder().ediName(ins).build());
         }

         /**
          * ********* Fake Certificate Type **********
          * ******************************************
          * ******************************************
          */

         String[] listCertificateType = { "Chứng chỉ CCNA", "Chứng chỉ CCIE", "Chứng chỉ CISM", "Chứng chỉ CISA",
                 "Chứng chỉ CISSP", "Chứng chỉ CRISC", "Chứng chỉ MCITP", "Chứng chỉ MCTS", "Chứng chỉ MCPD",
                 "Chứng chỉ MCSE và MCSA" };
         for (String cerType : listCertificateType) {
             certificateTypeRepository.save(CertificateType.builder().ctName(cerType).build());
         }

         /**
          * *************** Fake User ****************
          * ******************************************
          * ******************************************
          */
         for (int i = 0; i < 100; i++) {
             User user = new User();
             user.setFullname(faker.name().fullName());
             user.setEmail(faker.internet().emailAddress());
             user.setPhoneNumber(faker.phoneNumber().phoneNumber());
             user.setSex(faker.options().option("Male", "Female"));
             user.setPassword("321323");

             Object object = faker.options().option(new Student(), new Tutor(), new Admin());

             /**
              * ************* Fake Student ***************
              * ******************************************
              * ******************************************
              */

             Student student = Student.fromUser(user);
             student.setStuGrade(faker.options().option(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
             student.setStuSchool(schools.get(random.nextInt(schools.size())));

             /**
              * ************** Fake Staff ****************
              * ******************************************
              * ******************************************
              */

             Staff staff = Staff.fromUser(user);
             staff.setNationalId(generateRandomCitizenID());
             staff.setPlaceOfOrigin(faker.address().cityName() + "," + faker.address().country());
             staff.setDateOfBirth(randomDateOfBirth(6, 20));
             staff.setProfilePhoto(faker.lorem().characters().getBytes());

             /**
              * ************** Fake Tutor ****************
              * ******************************************
              * ******************************************
              */

             Tutor tutor = Tutor.fromStaff(staff);
             tutor.setBio(faker.lorem().characters());
             tutor.setRate(faker.options().option(0, 1, 2, 3, 4, 5));
             tutor.setInvitingCode(generateRandomCitizenID());
             tutor.setNOfInvitations(random.nextInt(1000));
             tutor.setDateJoined(randomDateOfBirth(0, 3));

             int rd = random.nextInt(0, tutors.size() + 1);
             Integer numRandTutor;
             for (int j = 0; j < rd; j++) {
                 do {
                     numRandTutor = random.nextInt(0, tutors.size());
                 } while (number.contains(numRandTutor));
                 number.add(numRandTutor);
                 tutor.setInvitedCode(tutors.get(numRandTutor));
             }
             number.clear();

             /**
              * *********** Fake Qualification ***********
              * ******************************************
              * ******************************************
              */

             int nRan = random.nextInt(1, 4);
             List<Qualification> qualifications = new ArrayList<>();
             for (int j = 0; j < nRan; j++) {
                 qualifications
                         .add(Qualification.builder().qualificationId(new QualificationId(tutor, faker.educator().course())).build());
             }
             tutor.setQualifications(qualifications);

             /**
              * ************** Fake Admin ****************
              * ******************************************
              * ******************************************
              */

             Admin admin = Admin.fromStaff(staff);
             // admin.setStaff(staff);

             if (object instanceof Admin) {
                 adminRepository.save(admin);
              } else if (object instanceof Tutor) {
              tutorRepository.save(tutor);
              tutors.add(tutor);
              } else {
              studentRepository.save(student);
              }
         }
     }
 }