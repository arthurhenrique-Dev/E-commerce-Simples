package Infra.Adapters.Input.Controllers;

import Application.DTOs.Users.DTOEmailValidation;
import Application.DTOs.Users.DTOSaveUser;
import Application.DTOs.Users.DTOSignInMaster;
import Application.DTOs.Users.DTOUpdatePasswordUser;
import Application.UseCases.User.*;
import Domain.ValueObjects.Cpf;
import Infra.Security.DTOs.DTOLogin;
import Infra.Security.Service.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("TecBom/auth")
public class AuthController {

    private final SaveUserUseCase saveUserUseCase;
    private final SaveAdminUseCase saveAdminUseCase;
    private final AddMasterUseCase addMasterUseCase;
    private final ConfirmEmailValidationTokenUseCase confirmEmailValidationTokenUseCase;
    private final ConfirmPasswordTokenUseCase confirmPasswordTokenUseCase;
    private final UpdatePasswordUserUseCase updatePasswordUserUseCase;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthController(SaveUserUseCase saveUserUseCase, SaveAdminUseCase saveAdminUseCase, AddMasterUseCase addMasterUseCase, ConfirmEmailValidationTokenUseCase confirmEmailValidationTokenUseCase, ConfirmPasswordTokenUseCase confirmPasswordTokenUseCase, UpdatePasswordUserUseCase updatePasswordUserUseCase, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.saveUserUseCase = saveUserUseCase;
        this.saveAdminUseCase = saveAdminUseCase;
        this.addMasterUseCase = addMasterUseCase;
        this.confirmEmailValidationTokenUseCase = confirmEmailValidationTokenUseCase;
        this.confirmPasswordTokenUseCase = confirmPasswordTokenUseCase;
        this.updatePasswordUserUseCase = updatePasswordUserUseCase;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("login")
    public ResponseEntity logIn(@RequestBody @Valid DTOLogin dtoLogin) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dtoLogin.cpf(), dtoLogin.password());

        var authentication = authenticationManager.authenticate(authenticationToken);

        Object domainObject = authentication.getPrincipal();

        String token = tokenService.generateToken(domainObject);

        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/register/user")
    public ResponseEntity registerUser(@RequestBody DTOSaveUser dtoSaveUser) {
        saveUserUseCase.saveUser(dtoSaveUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register/admin")
    public ResponseEntity registerAdmin(@RequestBody DTOSaveUser dtoSaveUser) {
        saveAdminUseCase.saveAdmin(dtoSaveUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register/master")
    public ResponseEntity registerMaster(@RequestBody DTOSignInMaster master) {
        addMasterUseCase.saveMaster(master);
        return ResponseEntity.ok().build();
    }

    @PutMapping("validate/email")
    public ResponseEntity validateEmail(@RequestBody DTOEmailValidation dtoEmailValidation) {
        confirmEmailValidationTokenUseCase.confirmEmailValidationToken(dtoEmailValidation);
        return ResponseEntity.ok().build();
    }

    @PutMapping("validate/password/token")
    public ResponseEntity validatePasswordToken(@RequestBody DTOUpdatePasswordUser dtoUpdatePasswordUser) {
        confirmPasswordTokenUseCase.confirmToken(dtoUpdatePasswordUser);
        return ResponseEntity.ok().build();
    }

    @PutMapping("validate/password/update")
    public ResponseEntity updatePassword(@RequestBody Cpf cpf) {
        updatePasswordUserUseCase.updatePassword(cpf);
        return ResponseEntity.ok().build();
    }
}
