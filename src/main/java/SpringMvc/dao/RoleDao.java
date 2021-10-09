package SpringMvc.dao;


import SpringMvc.model.Role;

import java.util.List;

public interface RoleDao {

    void addRole(Role role);

    void updateRole(Role role);

    void removeRoleById(long id);

    List<Role> getAllRoles();

    Role getRoleByName(String name);

}
