package xyz.jecy.api.axon.bean;

import org.axonframework.modelling.command.TargetAggregateIdentifier

data class CapitalCreateCmd(@TargetAggregateIdentifier val id: String, val amount: Int)
data class CapitalCreateEvt(val id: String, val amount: Int)


data class CapitalAddCmd(@TargetAggregateIdentifier val id: String, val amount: Int)
data class CapitalAddEvt(val id: String, val amount: Int)
