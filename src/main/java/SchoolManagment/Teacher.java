package SchoolManagment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher {
@Id
private int id;
private String name;
private String subject;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public long getSalary() {
	return salary;
}
public void setSalary(long salary) {
	this.salary = salary;
}
private long salary;
}
