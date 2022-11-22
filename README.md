# JetbrainsRepos

Implemented Architecture : 

Clean Architecture based on MVVM 

three layer : Data , Domaine , Presentation

Data Layer : contains dataresources ( in our case offline and online dataResources ) : Online -> github api , Offline -> Json file
Domaine Layer : Business Logic ( mappers that convert data from data layer to data used in our business logic ) 
Presentation Layer : contains Fragments , Adapters , Pagination , ViewModel ...

Technical Stack : 

DI : Hilt, Network : Retrofit , Pagination : Paging , UI : XML , swiperefreshlayout , Flows , Coroutines
