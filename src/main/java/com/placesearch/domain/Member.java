package com.placesearch.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of="uid")
@ToString
@Entity
public class Member {

    @Id
    private String uid;

    private String upw;

    private String uname;

    @CreationTimestamp
    private LocalDateTime regdate;

    @UpdateTimestamp
    private LocalDateTime updateddate;

//    @OneToMany(cascade= CascadeType.ALL, fetch=FetchType.EAGER)
//        @JoinColumn(name="member")
//        private List<MemberRole> roles;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "member")
    private List<MemberRole> roles;
}
