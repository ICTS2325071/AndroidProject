package com.example.teamateapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(
    val name: String,
    val flagResId: String,
    val imageResId: String,
    val playerInfo: PlayerInfo,
    val playerStats: PlayerStats,
    val careerStatsHardCourt: CareerStats,
    val careerStatsGrassCourt: CareerStats,
    val careerStatsClayCourt: CareerStats,
) : Parcelable

@Parcelize
data class PlayerInfo(
    val age: Int,
    val nationality: String,
    val height: Int,
    val weight: Int,
) : Parcelable

@Parcelize
data class PlayerStats(
    val ranking: Int,
    val points: Int,
    val matchesWon: Int,
    val matchesLost: Int,
    val winRate: Double,
    val tournamentsWon: Int,
) : Parcelable

@Parcelize
data class CareerStats(
    val matchesWon: Int,
    val matchesLost: Int,
    val winRate: Double,
    val tournamentsWon: Int,
) : Parcelable
