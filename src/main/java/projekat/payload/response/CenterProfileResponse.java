package projekat.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CenterProfileResponse {
    private Long id;
    private String name;
    private String address;
    private String city;
    private Double averageRating;
}
