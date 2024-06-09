package bar.api.service;

import bar.api.model.Despesas;
import bar.api.model.User;
import bar.api.repository.DespesasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DespesasService {
    @Autowired
    private DespesasRepository repository;

    public List<Despesas> findDespesasByUser(User user) {
        return repository.findByUser(user);
    }

    public List<Despesas> findByUserAndAnoAndMes(User user, Integer ano, Integer mes) {
        return repository.findByUserAndAnoAndMes(user, ano, mes);
    }

    @Transactional
    public Despesas gravar(Despesas despesa) {
        return repository.save(despesa);
    }

    public Optional<Despesas> getId(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void deletar(Optional<Despesas> despesa) {
        repository.delete(despesa.get());
    }
}
