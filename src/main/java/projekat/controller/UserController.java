package projekat.controller;

import projekat.model.User;
import projekat.payload.request.UpdateForm;
import projekat.service.UserService;
import projekat.payload.request.UpdatePasswordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/me")
    public User getCurrentUser(@AuthenticationPrincipal User currentUser) {
        return service.getUserById(currentUser.getId());
    }

    @GetMapping("/rank")
    public ResponseEntity<?> getUserRank(@AuthenticationPrincipal User currentUser) {
        return service.getUserRank(currentUser.getId());
    }

    @PutMapping("/update")
    public User updateUserData(@AuthenticationPrincipal User currentUser, @RequestBody UpdateForm updatedUser) {
        return service.updateUser(currentUser.getId(), updatedUser);
    }

    @PutMapping("/update/password")
    public User updatePassword(@AuthenticationPrincipal User currentUser, @RequestBody UpdatePasswordRequest updatePasswordRequest) {
        return service.updatePassword(currentUser.getId(), updatePasswordRequest.getCurrentPassword(), updatePasswordRequest.getNewPassword());
    }

}