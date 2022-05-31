package com.example.jalka.data.models

data class MatchesResponse(
    val matches: List<Match>
)

data class Match(
    val team1: String,
    val team2: String
)

/*
{
	"matches":[
		{
			"team1":"Paris",
			"team2":"Chelsea"
		},
		{
			"team1":"Benfica",
			"team2":"Zenit"
		},
		{
			"team1":"Gent",
			"team2":"Wolfsburg"
		},
		{
			"team1":"Roma",
			"team2":"Real Madrid"
		},
		{
			"team1":"Arsenal",
			"team2":"Barcelona"
		},
		{
			"team1":"Juventus",
			"team2":"Bayern"
		},
		{
			"team1":"PSV",
			"team2":"Atlético"
		},
		{
			"team1":"Dynamo Kyiv",
			"team2":"Man. City"
		}
	]
}
 */
