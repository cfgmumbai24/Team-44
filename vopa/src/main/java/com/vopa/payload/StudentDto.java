package com.vopa.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class StudentDto {
	private int id;
	private String name;
	private int std;
	private String gender;
	private String dob;
}
