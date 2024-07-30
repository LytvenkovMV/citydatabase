package org.example.citydatabase.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Date;

@Entity
@Data
@Table(name = "persons")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "series")
    private Integer series;

//    @Column(name = "number")
////    @GeneratedValue(generator = "sequence-generator")
////    @GenericGenerator(
////            name = "sequence-generator",
////            parameters = {
////                    @Parameter(name = "sequence_name", value = "user_sequence"),
////                    @Parameter(name = "initial_value", value = "4"),
////                    @Parameter(name = "increment_size", value = "1")
////            }
////    )
//    private Long number;

    @Column(name = "office_code")
    private String officeCode;

    @Column(name = "issue_date")
    private Date issueDate;
}
