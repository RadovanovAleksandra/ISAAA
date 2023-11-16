package projekat.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import projekat.model.User;
import projekat.payload.request.UpdatePasswrodRequest
import projekat.payload.request.UpdateForm;
import projekat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public User getCurrentUser(@AuthenticationPrincipal User currentUser) {
        return userService.getUserById(currentUser.getId());
    }

    @GetMapping("/rank")
    public ResponseEntity<?> getUserRank(@AuthenticationPrincipal User currentUser) {
        return userService.getUserRank(currentUser.getId());
    }

    @PutMapping("/update")
    public User updateUserData(@AuthenticationPrincipal User currentUser, @RequestBody UpdateForm updatedUser) {
        return userService.updateUser(currentUser.getId(), updatedUser);
    }

    @PutMapping("/update/password")
    public User updatePassword(@AuthenticationPrincipal User currentUser, @RequestBody UpdatePasswrodRequest updatePasswordRequest) {
        return userService.updatePassword(currentUser.getId(), updatePasswordRequest.getCurrentPassword(), updatePasswordRequest.getNewPassword());
    }
}