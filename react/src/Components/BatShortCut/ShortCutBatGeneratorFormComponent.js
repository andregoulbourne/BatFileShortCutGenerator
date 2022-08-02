import { useState } from "react";
import axios from "axios";

import { generateShortCutUrl } from "../../api/Api";




export default function BatShortCutGeneratorForm() {
  const [pathWithEXEFile, setPathWithEXEFile] = useState("");
  const [writeOutPath, setWriteOutPath] = useState("");
  const [shortCutName, setShortCutName] = useState("");

  const handleSetPathWithEXEFile = (value) => {
    setPathWithEXEFile(value)
  }

  const handleSetWriteOutPath = (value) => {
    setWriteOutPath(value)
  }

  const handleSetShortCutName = (value) => {
    setShortCutName(value.toString())
  }

  return (
    <>

      <form>
        <h3 align="center">Bat ShortCut File Generator!</h3>
        <div>

          <label htmlFor="pathWithEXEFile">Exe File:</label>
          <input 
            type="text" 
            name="pathWithEXEFile" 
            value={pathWithEXEFile}
            onChange={(element) => {handleSetPathWithEXEFile(element.target.value)}}
            placeholder="Choose an exe file"/>

          <label htmlFor="writeOutPath">Write Out Path:</label>
          <input 
            type="text" 
            name="writeOutPath" 
            value={writeOutPath}
            onChange={(element) => {handleSetWriteOutPath(element.target.value)}}
            placeholder="Choose a write out path"/>

          <label htmlFor="shortCutName">Shortcut Name:</label>
          <input 
            type="text" 
            name="shortCutName" 
            value={shortCutName}
            onChange={(element) => {handleSetShortCutName(element.target.value)}}
            placeholder="Enter a name for your ShortCut" />
        </div>
        <br/>
        <button class="btn btn-primary" onClick={() => {
            axios.post(generateShortCutUrl,null,{params: {pathWithEXEFile,writeOutPath,shortCutName}})
                .then(respMap => {
                    if(respMap.success){
                        console.log("File Generated Successfully")
                        alert("File Generated Successfully")
                    } else {
                        console.log("File Generation Failed")
                        alert("File Generation Failed")
                    }
                    
                })
                .catch(error => {
                    console.error(error);
                });
          }    
        }>Generate</button>
      </form>
      

    </>
  );
} 