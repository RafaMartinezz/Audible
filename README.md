# Audible sound playback project

This Java project demonstrates the use of audio playback for various types of objects, such as **animals**, **instruments**, **events**, and **people**. Each object implements the `Audible` interface, which requires the ability to produce a sound. The project includes classes for playing pre-recorded `.wav` files and for synthesizing MIDI sounds, allowing for flexible audio playback options.

## Table of Contents

- [Overview](#overview)
- [Purpose](#purpose)
- [Features](#features)
- [Class Structure](#class-structure)
- [Input Format](#input-format)
- [Example Input and Output](#example-input-and-output)
- [Explanation](#explanation)

---

## Overview

The project uses Java’s audio libraries to enable sound playback for a range of objects. It demonstrates polymorphism by using the `Audible` interface, allowing each object to implement its unique sound in different ways. The project supports both pre-recorded audio files and synthesized MIDI sounds, enhancing the versatility of sound playback.

## Purpose

This project serves as a **learning exercise** in:
- Using **interfaces** to enforce sound-playing capabilities across diverse object types.
- Working with Java’s **audio libraries** for `.wav` file playback and MIDI sound synthesis.
- Implementing **polymorphism** to allow different objects to handle sound playback in unique ways.

## Features

- **Audible Interface**: Defines the `sonar` method, which all sound-producing classes must implement.
- **Pre-recorded Sound Playback**: Uses the `SonidoMuestreado` class to play `.wav` audio files, enabling objects like `Animal` and `Evento` to produce realistic sounds.
- **MIDI Synthesized Sound**: Uses the `SonidoSintetizado` class to generate synthesized instrument sounds for objects like `Piano` and `Flauta`.
- **Volume Control**: The `SonidoMuestreado` class includes a method to adjust volume during playback.

## Class Structure

- **`Audible`**: Interface that requires implementing classes to define a `sonar` method for playing sound.
- **`SonidoMuestreado`**: Manages playback of `.wav` audio files. Supports volume control and handles audio-related exceptions.
- **`SonidoSintetizado`**: Uses Java’s MIDI system to synthesize sounds for specific instruments, playing a short melody.
- **`Animal`**: Represents an animal with an associated sound file (e.g., "horse" or "rooster") in `.wav` format.
- **`Evento`**: Represents an event with an associated audio recording (e.g., "Apollo launch" sound).
- **`Persona`**: Represents a person who can produce a sound based on gender, playing different `.wav` files for male and female laughter.
- **`Instrumento`**: Abstract class for instruments. Specific instruments like `Piano` and `Flauta` extend this class and produce synthesized sounds.

## Input Format

The program initializes various `Audible` objects directly in the code, each with attributes specific to their type:
- **`Animal`**: Takes a name and the path to a `.wav` sound file.
- **`Persona`**: Takes a name and gender, playing a predefined audio file based on gender.
- **`Evento`**: Takes an event name and the path to a `.wav` sound file.
- **`Piano` and `Flauta`**: Require a MIDI instrument code and generate synthesized sound.

## Example Input and Output

### Input

The following code initializes several `Audible` objects and plays each sound:

```java
Audible[] sonidos = new Audible[4];
sonidos[0] = new Animal("Horse", "Horse.wav");
sonidos[1] = new Persona("Emilio", "Hombre");
sonidos[2] = new Piano();
sonidos[3] = new Evento("Apollo Launch", "ApolloLaunch.wav");

for (Audible sonido : sonidos) {
    try {
        sonido.sonar();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

### Output

```plaintext
Playing Horse.wav
Playing Hombre_risa.wav
Playing piano sound (synthesized)
Playing ApolloLaunch.wav
```

### Explanation

- Each object’s `sonar` method plays the respective sound, either by playing a `.wav` file or generating a synthesized melody.
- Pre-recorded sounds are managed by `SonidoMuestreado`, while instrument sounds are synthesized with `SonidoSintetizado` using MIDI codes.

## Explanation

The project’s flexible structure allows it to be easily extended to accommodate additional sound-producing classes. By using interfaces and polymorphism, it provides a simple yet powerful framework for managing audio playback for diverse types of objects.