package com.fortbank.ATM.services;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.fortbank.ATM.entity.Cliente;
import com.fortbank.ATM.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService 
{
    private final ClienteRepository clienteRepository;

    public Cliente crearCliente(Cliente cliente)
    {
        cliente.setBloqueado(false);
        cliente.setIntentosFallidos(0);
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente>buscarPorIdentificacion(String identificacion)
    {
        return clienteRepository.findByIdentificacion(identificacion);
    }

    public boolean validarPin(Cliente cliente, String pin)
    {
        if(cliente.isBloqueado()) return false;

        if(cliente.getPin().equals(pin))
        {
            cliente.setIntentos(0);
            clienteRepository.save(cliente);
            return true;
        }else{
            int intentos = cliente.getIntentos() + 1;
            cliente.setIntentos(intentos);
            if(intentos >= 3)
            {
                cliente.setBloqueado(true);
            }
            clienteRepository.save(cliente);
            return false;
        }
    }

    public void desbloquearCliente(String identificacion, String nuevoPin){
        Optional<Cliente> optionalCliente = clienteRepository.findByIdentificacion(identificacion);
        if(optionalCliente.isPresent()){
            Cliente cliente = optionalCliente.get();
            cliente.setBloqueado(false);
            cliente.setIntentosFallidos(0);
            cliente.setPin(nuevoPin);
            clienteRepository.save(cliente);
        }else{
            throw new RuntimeException("Cliente no encontrado");
        }
    }

    public void cambiarPin(Cliente cliente, String nuevoPin){
        cliente.setPin(nuevoPin);
        clienteRepository.save(cliente);
    }

    public void incrementarIntento(Cliente cliente){
        cliente.setIntentosFallidos(cliente.getIntentosFallidos() + 1);
        clienteRepository.save(cliente);
    }

    public void reiniciarIntentos(Cliente cliente){
        cliente.setIntentosFallidos(0);
        clienteRepository.save(cliente);
    }

    public void bloquearCliente(Cliente cliente){
        cliente.setBloqueado(true);
        clienteRepository.save(cliente);
    }
}
