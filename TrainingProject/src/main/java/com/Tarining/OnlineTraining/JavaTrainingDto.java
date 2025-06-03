package com.Tarining.OnlineTraining;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JavaTrainingDto {
	
    private String id;
    
    @NotEmpty(message = "Name Cannot be Blank")
    @Size(min = 3,max = 20, message = "min 3 and max 20 character is allolwed for Name!!!")
    private String name;
    
    @NotEmpty(message = "Email cannot be Blank")
    @Email
	private String email;
    
    @NotEmpty(message = "Mobile cannot be Blank")
    @Size(min = 10, max = 10, message = "Mobile Must be digits")
	private String mobile;
    
    
    @NotEmpty(message = "Fees Cannot be Blank")
    @Min(value = 2000, message = "Minimum Fees Must be 20.5")
    @Max(value = 20000, message = "Maximum Fees Must be 20000")
	private int fees;

}
