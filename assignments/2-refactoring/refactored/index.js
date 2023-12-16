'use strict';

// Importing libraries
const fs = require('fs');

// Top level variables
const repositoryUrl = 'https://github.com/sindresorhus/pokemon';
const reportText = `Please report to ${repositoryUrl}/issues if we missed something.`;
const languages = getLanguagesFromDirectory();

/**
 * Retrieves the languages from the data directory.
 * The files within the directory are retrieved and their extension is removed.
 *
 * @returns {Array} An array containing the languages found in the directory.
 */
function getLanguagesFromDirectory() {
	return fs.readdirSync('./data/').map(
		file => file.split('.')[0]
	);
}

/**
 * Retrieves the localized list of pokémon based on the given language.
 *
 * @param {string} language The language code used to determine which localized list to retrieve. Default: "en".
 * @returns {*} The localized list of data.
 * @throws {Error} If the localized list for the specified language does not exist.
 */
function getLocalizedList(language = 'en') {
	if (!languages.includes(language)) {
		throw new Error(
			`Localized list for language code '${language}' does not exist. Pull request welcome: ${repositoryUrl}`
		);
	}

	return require(`./data/${language.toLowerCase()}.json`);
}

/**
 * Returns a random element from the localized list of pokémon based on the specified language.
 *
 * @param {string} language The language code used to determine which localized list to retrieve. Default: "en".
 * @returns {string} A random element from the localized list of names.
 */
function random(language = 'en') {
	const localizedNames = getLocalizedList(language);
	const randomIndex = Math.floor(Math.random() * localizedNames.length)
	return localizedNames[randomIndex];
}

/**
 * Returns the name of a Pokémon based on its Pokédex number and language.
 * If the Pokémon does not exist, an error is thrown.
 *
 * @param {number} pokedexNumber The Pokédex number of the Pokémon.
 * @param {string} language The language code used to determine which localized list to retrieve. Default: "en".
 * @returns {string} The name of the Pokémon.
 * @throws {Error} If the Pokémon with the given Pokédex number does not exist.
 */
function getName(pokedexNumber, language = 'en') {
	const list = getLocalizedList(language);
	const name = list[pokedexNumber - 1];

	if (!name) {
		throw new Error(`Pokémon with ID '${pokedexNumber}' does not exist. ${reportText}`);
	}

	return name;
}

/**
 * Retrieves the Pokédex number for a given Pokémon name.
 *
 * @param {string} name - The name of the Pokémon.
 * @param {string} language The language code used to determine which localized list to retrieve. Default: "en".
 * @returns {*} - The Pokédex number of the Pokémon.
 * @throws {Error} If the Pokémon with the given name does not exist for the specified language.
 */
function getPokedexNumber(name, language = 'en') {
	const list = getLocalizedList(language);
	const index = list.indexOf(name);

	if (index === -1) {
		throw new Error(`Pokémon with name '${name}' does not exist for language code '${language}'. ${reportText}`);
	}

	return index + 1;
}

// Exporting elements of the module
module.exports = {
	"languages": languages,
	"all": getLocalizedList,
	"random": random,
	"getName": getName,
	"getId": getPokedexNumber
};
