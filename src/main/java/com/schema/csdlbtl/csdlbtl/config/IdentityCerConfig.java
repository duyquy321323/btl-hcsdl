//package com.schema.csdlbtl.csdlbtl.config;
//
//import com.schema.csdlbtl.csdlbtl.entity.CerSequence;
//import com.schema.csdlbtl.csdlbtl.repository.CerSequenceRepository;
//import com.schema.csdlbtl.csdlbtl.util.StaticValue;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Optional;
//
//@Configuration
//public class IdentityCerConfig {
//
//    @Autowired
//    private CerSequenceRepository cerSequenceRepository;
//
//    @Bean
//    public void identityBean(){
//        Optional<CerSequence> id = cerSequenceRepository.findById(1L);
//        if(id.isEmpty()){
//            cerSequenceRepository.save(CerSequence.builder().sequence(1L).build());
//            StaticValue.cerSequence = 1L;
//        }
//        else{
//            StaticValue.cerSequence = id.get().getSequence() + 1;
//        }
//    }
//}
