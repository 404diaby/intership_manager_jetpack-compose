package com.diaby404.intership_manager_jetpack_compose


data class Offer(
    val id: String,
    val title: String,
    val description: String,
    val location: String,



)



/*
data class OfferScreenState(
    val offers: List<Offer> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

@Preview
@Composable
fun Display(){
    val viewModel: OfferViewModel = viewModel()
    OfferScreen(viewModel = viewModel)
    viewModel.loadOffers()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfferScreen(viewModel: OfferViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Offres") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when {
                uiState.isLoading -> CircularProgressIndicator()
                uiState.error != null -> Text(uiState.error!!)
                else -> {
                    OfferList(offers = uiState.offers)
                    OfferInput(onSubmit = { title, desc, price ->
                        // Ajouter la logique pour ajouter une offre
                    })
                }
            }
        }
    }
}








*/