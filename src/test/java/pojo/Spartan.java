package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@JsonIgnoreProperties(value = "id",allowGetters = true)

public class Spartan {

    private int id;
    private String name;
    private String gender;
    private long phone;
    private String email;
}




//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public long getPhone() {
//        return phone;
//    }
//
//    public void setPhone(long phone) {
//        this.phone = phone;
//    }
//
//    @Override
//    public String toString() {
//        return "Spartan{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", gender='" + gender + '\'' +
//                ", phone=" + phone +
//                '}';
//    }
//}
