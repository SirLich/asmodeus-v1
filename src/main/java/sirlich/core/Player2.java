package sirlich.core;

import sirlich.abilities.Ability;

public class Player2 {
	private Ability toggleFlyAbility;
	private Ability switchHandAbility;
	private Ability	dropWeaponAbility;

	public Ability getToggleFlyAbility() {
		return toggleFlyAbility;
	}

	public void setToggleFlyAbility(Ability doubleJumpAbility) {
		this.toggleFlyAbility = doubleJumpAbility;
	}

	public Ability getSwitchHandAbility() {
		return switchHandAbility;
	}

	public void setSwitchHandAbility(Ability switchHandAbility) {
		this.switchHandAbility = switchHandAbility;
	}

	public Ability getDropWeaponAbility() {
		return dropWeaponAbility;
	}

	public void setDropWeaponAbility(Ability dropWeaponAbility) {
		this.dropWeaponAbility = dropWeaponAbility;
	}
	
}
