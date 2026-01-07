package Infra.Adapters.Input.Controllers;

import Application.DTOs.Users.DTOSearchUser;
import Application.UseCases.User.*;
import Domain.ValueObjects.Cpf;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/TecBom/admin_dashboard/")
public class AdminController {

    private final DeleteMasterUseCase deleteMasterUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final DissmissAdminUseCase dissmissAdminUseCase;
    private final HireUserUseCase hireUserUseCase;
    private final ReactivateUserUseCase reactivateUserUseCase;
    private final SearchUserUseCase searchUserUseCase;
    private final SearchAdminUseCase searchAdminUseCase;

    public AdminController(DeleteMasterUseCase deleteMasterUseCase, DeleteUserUseCase deleteUserUseCase, DissmissAdminUseCase dissmissAdminUseCase, HireUserUseCase hireUserUseCase, ReactivateUserUseCase reactivateUserUseCase, SearchUserUseCase searchUserUseCase, SearchAdminUseCase searchAdminUseCase) {
        this.deleteMasterUseCase = deleteMasterUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.dissmissAdminUseCase = dissmissAdminUseCase;
        this.hireUserUseCase = hireUserUseCase;
        this.reactivateUserUseCase = reactivateUserUseCase;
        this.searchUserUseCase = searchUserUseCase;
        this.searchAdminUseCase = searchAdminUseCase;
    }

    @DeleteMapping("/master")
    public ResponseEntity deleteMaster(@RequestBody @Valid Cpf cpf) {
        deleteMasterUseCase.deleteMasterUser(cpf);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/user/stats")
    public ResponseEntity deleteUser(@RequestBody @Valid Cpf cpf) {
        deleteUserUseCase.deleteUserByCpf(cpf);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/master")
    public ResponseEntity dissmissAdmin(@RequestBody @Valid Cpf cpf) {
        dissmissAdminUseCase.dissmissAdmin(cpf);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/user")
    public ResponseEntity hireUser(@RequestBody @Valid Cpf cpf) {
        hireUserUseCase.hireUser(cpf);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user/stats")
    public ResponseEntity reactivateUser(@RequestBody @Valid Cpf cpf) {
        reactivateUserUseCase.reactivateUser(cpf);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user")
    public ResponseEntity searchUser(@RequestBody @Valid DTOSearchUser dtoSearchUser) {
        return ResponseEntity.ok(searchUserUseCase.searchUsers(dtoSearchUser));
    }

    @GetMapping("/admin")
    public ResponseEntity searchAdmin(@RequestBody @Valid DTOSearchUser dtoSearchUser){
        return ResponseEntity.ok(searchAdminUseCase.searchAdmins(dtoSearchUser));
    }


}
