/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React, {useState} from 'react';
import { StyleSheet, Text, TouchableOpacity, View, NativeModules } from "react-native";
import Vista from './app/vista'

// const Manager = NativeModules.Manager;
// const Bluetooth = NativeModules.Bluetooth;

const {Manager, Bluetooth} = NativeModules;

const App = () => {

  greetUserCallback= async() => {
    // const state = this.state;
    // Manager.greetUser("juan", displayResult);
    // Bluetooth.getDevices(displayResult);

    try{
      let x = await Bluetooth.getDevices()
      console.log(x);
    }catch(err){
      console.log(err);
    }
  }
  displayResult=(result)=>{
    // this.refs.userName.blur();
    // this.setState({greetingMessage:result});
    console.log(result);
  }  

  return (
    <View style={styles.container}>
      <View style={styles.countContainer}>
        <Text>Hola</Text>
        <TouchableOpacity
                style={styles.button}
                onPress={greetUserCallback}
            >
            <Text>Press Here</Text>
        </TouchableOpacity>
      </View>
      {/* <Vista /> */}
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    paddingHorizontal: 10
  },
  button: {
    alignItems: "center",
    backgroundColor: "#DDDDDD",
    padding: 10
  },
  countContainer: {
    alignItems: "center",
    padding: 10
  }
});

export default App;