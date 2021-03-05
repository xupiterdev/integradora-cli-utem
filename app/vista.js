import React, {useState} from 'react'
import { StyleSheet, Text, TouchableOpacity, View } from "react-native";

function Vista(){
    // VARIABLES
    const [count, setCount] = useState(0);
  const onPress = () => setCount(prevCount => prevCount + 1);

    // FUNCTIONS

    // RENDER
    return(
        
        <>
            <Text>Count: {count}</Text>
            <TouchableOpacity
                style={styles.button}
                onPress={onPress}
            >
            <Text>Press Here</Text>
        </TouchableOpacity>
        </>
    )
}

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

export default Vista;