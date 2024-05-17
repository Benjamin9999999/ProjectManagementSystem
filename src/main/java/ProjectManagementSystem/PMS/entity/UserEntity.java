package ProjectManagementSystem.PMS.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.management.relation.Role;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name= "user_name")
@Getter
@Setter
@Data


public class UserEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @Column(name = "user_name")
        private String username;
        @Column(name = "Password")
        private String password;
        @Column(name = "roles")
        private Role role;
        }

