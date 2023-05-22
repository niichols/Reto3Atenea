package com.example.reto3.Service;

import com.example.reto3.Model.Gama;
import com.example.reto3.Repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamaService {
    @Autowired
    private GamaRepository gamaRepository;
    public List<Gama> getAll(){
        return gamaRepository.findAll();
    }
    public Optional<Gama> getGama(int id){
        return gamaRepository.getGama(id);
    }
    public Gama save(Gama gama){
        if (gama.getIdGama() == null){
            return gamaRepository.save(gama);
        }else {
            Optional<Gama> gamaEncontrado = getGama(gama.getIdGama());
            if (gamaEncontrado.isEmpty()){
                return gamaRepository.save(gama);
            }else {
                return gama;
            }
        }
    }

    public Gama Update(Gama gama) {
        if (gama.getIdGama() != null) {
            Optional<Gama> gamaEncontrado = getGama(gama.getIdGama());

            if (gamaEncontrado.isPresent()) {

                if (gama.getName() != null) {
                    gamaEncontrado.get().setName(gama.getName());
                }
                if (gama.getDescription() != null) {
                    gamaEncontrado.get().setName(gama.getName());
                }
                return gamaRepository.save(gamaEncontrado.get());
            } else {
                return gama;
            }
        } else {
            return gama;
        }
    }

    public boolean deleteGama(int id){
        Boolean respuesta = getGama(id).map(gama -> {
            gamaRepository.delete(gama);
            return true;
        }).orElse(false);
        return respuesta;
    }

}
