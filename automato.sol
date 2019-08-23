pragma solidity ^0.5.11;

contract automato {

	enum Stages {
		estado29,
		estado30,
		estado31,
		estado32,
		estado33,
		estado34,
		estado35,
		estado36,
		estado37,
		estado38,
		estado39,
		estado40,
		estado41,
		estado42,
		estado43,
		estado44,
		estado45,
		estado46,
		estado47,
		estado48,
		estado49,
		estado50,
		estado51,
		estado52,
		estado53,
		estado54,
		estado0,
		estado1,
		estado2,
		estado3,
		estado4,
		estado5,
		estado6,
		estado7,
		estado8,
		estado9,
		estado10,
		estado11,
		estado12,
		estado13,
		estado14,
		estado15,
		estado16,
		estado17,
		estado18,
		estado19,
		estado20,
		estado21,
		estado22,
		estado23,
		estado24,
		estado25,
		estado26,
		estado27,
		estado28
	}

	Stages public stage = Stages.estado0;
	address b;
	address s;
	address k;
	address c;

	modifier onlyB(){
		require(msg.sender == b);
		_;
	}

	modifier onlyS(){
		require(msg.sender == s);
		_;
	}

	modifier onlyK(){
		require(msg.sender == k);
		_;
	}

	modifier onlyC(){
		require(msg.sender == c);
		_;
	}

	modifier atStage(Stages _stage) {
		require(stage == _stage);
		_;
	}

	constructor(address _b, address _s, address _k, address _c) internal {
		b = _b;
		s = _s;
		k = _k;
		c = _c;
	}
}
