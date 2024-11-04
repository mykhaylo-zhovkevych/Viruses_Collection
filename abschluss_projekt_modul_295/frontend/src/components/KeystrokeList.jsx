import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './KeystrokeList.css';

const KeystrokeList = ({ session, onBack }) => {
    const [keystrokes, setKeystrokes] = useState([]);
    const [error, setError] = useState(null);

    useEffect(() => {
        if (!session || !session.sessionId) {
            setError("Invalid session data.");
            return;
        }

        const fetchKeystrokes = async () => {
            try {
                const response = await axios.get(`/api/keystrokes/session/${session.sessionId}`);
                setKeystrokes(response.data);
                setError(null);
            } catch (error) {
                console.error("Error fetching keystrokes:", error);
                setError("Failed to load keystrokes.");
            }
        };

        fetchKeystrokes();
    }, [session]);

    return (
        <div className='KeystrokeList'>
            <h3>Keystrokes for Session ID: {session.sessionId}</h3>
            <button onClick={onBack}>Back to Sessions</button>
            {error ? (
                <p>{error}</p>
            ) : (
                <ul>
                    {keystrokes.map((keystroke) => (
                        <li key={keystroke.keystrokeId}>
                            <h4>Keystroke ID: {keystroke.keystrokeId}</h4>
                            <p><strong>Text:</strong> {keystroke.text}</p>
                            <p><strong>Action:</strong> {keystroke.action}</p>
                            <p><strong>Sent Date:</strong> {new Date(keystroke.sentDate).toLocaleString()}</p>
        
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default KeystrokeList;
