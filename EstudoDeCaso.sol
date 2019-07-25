pragma solidity ^0.4.11;
contract EstudoDeCaso {
	address b;
	address s;
	address k;
	address c;
modifier onlyb(){
	require(msg.sender == b);
	_;
}
modifier onlys(){
	require(msg.sender == s);
	_;
}
modifier onlyk(){
	require(msg.sender == k);
	_;
}
modifier onlyc(){
	require(msg.sender == c);
	_;
}
}
