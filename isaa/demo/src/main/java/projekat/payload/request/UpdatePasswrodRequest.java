package projekat.payload.request;

import lombok.Data;

@Data
public class UpdatePasswrodRequest {
    private String currentPassword;
    private String newPassword;
}
