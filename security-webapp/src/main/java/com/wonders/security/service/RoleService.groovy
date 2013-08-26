package com.wonders.security.service

import com.wonders.security.entity.Role

interface RoleService {

	Role maintainRoleResc(long roleId, long... rescIds)

}
