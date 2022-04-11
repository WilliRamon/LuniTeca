package com.luniteca.luniteca.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.luniteca.luniteca.model.Usuario;
import com.luniteca.luniteca.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<Usuario> usuario = userRepository.findByEmail(userName);
		usuario.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));
		
		return usuario.map(UserDetailsImpl::new).get();
	}

}