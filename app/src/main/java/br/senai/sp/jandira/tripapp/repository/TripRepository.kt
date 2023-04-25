package br.senai.sp.jandira.tripapp.repository

import br.senai.sp.jandira.tripapp.model.Trip
import java.time.LocalDate

class TripRepository {
    companion object{
        fun getTrips(): List<Trip>{
            return listOf(
                Trip(
                    id = 1,
                    location = "Jandira",
                    description = "cidade feia, nao voltarei aqui, nada legal",
                    starDate = LocalDate.of(2023, 4, 21),
                    endDate = LocalDate.of(2023, 4 , 23)

                ),
                Trip(
                    id = 2,
                    location = "Sao Roque",
                    description = "cidade legal, iria novamente",
                    starDate = LocalDate.of(2023, 4, 21),
                    endDate = LocalDate.of(2023, 4 , 23)

                ),
                Trip(
                    id = 3,
                    location = "Rio de janeiro",
                    description = "cidade bonita, muito legal",
                    starDate = LocalDate.of(2023, 4, 21),
                    endDate = LocalDate.of(2023, 4 , 23)

                )
            )
        }
    }
}