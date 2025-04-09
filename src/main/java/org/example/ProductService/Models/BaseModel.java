package org.example.ProductService.Models;



import lombok.Getter;
import lombok.Setter;

import javax.swing.plaf.nimbus.State;
import java.util.Date;

@Setter
@Getter

public abstract class BaseModel {

    private Long Id;
    private State state;
    private Date createdAt;
    private Date updatedAt;

}
