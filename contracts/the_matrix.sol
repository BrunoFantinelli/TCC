pragma solidity ^0.5.11;

contract the_matrix {

	enum Stages {
		estado0,
		estado1,
		estado2,
		estado3,
		estado4,
		estado5,
		estado6,
		estado7
	}

	Stages public stage = Stages.estado0;
	address neo;
	address morpheus;
	address smith;

	modifier onlyNEO(){
		require(msg.sender == neo);
		_;
	}

	modifier onlyMORPHEUS(){
		require(msg.sender == morpheus);
		_;
	}

	modifier onlySMITH(){
		require(msg.sender == smith);
		_;
	}

	modifier atStage(Stages _stage) {
		require(stage == _stage);
		_;
	}

	function showTrue() public {

	//TODO Escreva as funcoes aqui

	}

	function hideTrue() public {

	//TODO Escreva as funcoes aqui

	}

	function redPill() public {

	//TODO Escreva as funcoes aqui

	}

	function bluePill() public {

	//TODO Escreva as funcoes aqui

	}

	function saveWorld() public {

	//TODO Escreva as funcoes aqui

	}

	function destroyMatrix() public {

	//TODO Escreva as funcoes aqui

	}

	function forget() public {

	//TODO Escreva as funcoes aqui

	}

	function liveInIgnorance() public {

	//TODO Escreva as funcoes aqui

	}
}
