package petshop.external;

import java.util.Date;
import lombok.Data;

@Data
public class PetProfile {

    private Long id;
    private Object age;
    private String size;
    private String gender;
    private String preferences;
    private String needs;
    private Object allegies;
    private Object petType;
}
