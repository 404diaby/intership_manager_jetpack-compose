package com.diaby404.intership_manager_jetpack_compose.test
































/*
class OfferViewModel: ViewModel() {
    // StateFlow stocke et émet l'état de notre écran
    private val _uiState = MutableStateFlow(OfferScreenState())
    val uiState: StateFlow<OfferScreenState> = _uiState

    // Fonction pour charger les offres
    fun loadOffers() {
        viewModelScope.launch {
            // Indique qu'on est en train de charger
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                // Simulez un chargement de données
                val offers = listOf(
                    Offer("1", "Offre 1", "Description 1", "Paris"),
                    Offer("2", "Offre 2", "Description 2", "Dijon")
                )
                // Met à jour l'état avec les offres chargées
                _uiState.value = OfferScreenState(offers = offers)
            } catch (e: Exception) {
                // En cas d'erreur, met à jour l'état avec le message d'erreur
                _uiState.value = OfferScreenState(error = e.message)
            }
        }
    }
}


 */

