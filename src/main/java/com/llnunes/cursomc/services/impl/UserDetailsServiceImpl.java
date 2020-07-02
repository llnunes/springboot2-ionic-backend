package com.llnunes.cursomc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.llnunes.cursomc.domain.Cliente;
import com.llnunes.cursomc.repositories.ClienteRepository;
import com.llnunes.cursomc.security.UserSS;

public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private ClienteRepository clienteRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Cliente cliente = clienteRepo.findByEmail(email);
		
		if(cliente == null) {
			throw new UsernameNotFoundException(email);
		}
				
		return new UserSS(cliente);
	}

}
