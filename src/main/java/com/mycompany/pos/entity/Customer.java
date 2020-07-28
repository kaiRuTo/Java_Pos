package com.mycompany.pos.entity;

import com.mycompany.pos.util.StringPrefixedSequenceIdGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "customer")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString(includeFieldNames=true)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cseq")
    @GenericGenerator(
            name = "cseq",
            strategy = "com.mycompany.pos.util.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "KH"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d") })
    @ToString.Exclude
    @Column(name = "id_customer")
    private String idCustomer;

    @Column(name = "firstName")
    @NotBlank
    private String firstName;

    @Column(name = "lastName")
    @NotBlank
    private String lastName;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "phone")
    private String phone;

    @Column(name = "createdAt", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;
}
