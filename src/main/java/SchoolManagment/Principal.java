package SchoolManagment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Principal {


private String name;
private int age;
@Id
private String phono;
private String email;
private String password;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getPhono() {
	return phono;
}
public void setPhono(String phono) {
	this.phono = phono;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
