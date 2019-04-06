package com.codependent.insuranceinc.globalposition.dto

data class GlobalPosition(val customerProfile: CustomerProfile, val carPolicies: List<CarPolicy>, val homePolicies: List<HomePolicy>)
