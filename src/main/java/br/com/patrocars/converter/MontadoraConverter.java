package br.com.patrocars.converter;

import br.com.patrocars.domain.model.montadora.Montadora;
import br.com.patrocars.domain.model.montadora.repository.MontadoraRepository;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MontadoraConverter implements Converter<String, Montadora> {
    @Override
    public Montadora convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        UUID uuid = UUID.fromString(source);
        // Criando uma Montadora apenas com o UUID (proxy)
        Montadora montadora = new Montadora();
        montadora.setId(uuid);
        return montadora;
    }
}
